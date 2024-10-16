package com.elqassmi.services;

import com.elqassmi.dao.RecommandationRepository;
import com.elqassmi.domain.Recommandation;
import com.elqassmi.dto.request.RecommandationRequest;
import com.elqassmi.dto.response.RecommandationResponse;
import com.elqassmi.exception.RecommndationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecommendationServicesImp  implements RecommandationServices{
    @Autowired
    RecommandationRepository recommandationRepository;

    @Override
    public long addRecommendation(RecommandationRequest recommandationRequest) {
        Recommandation recommandation = new Recommandation();
        recommandation.setAuthor(recommandationRequest.getAuthor());
        recommandation.setRole(recommandationRequest.getRole());
        recommandation.setContent(recommandationRequest.getContent());
        recommandation.setRecommendationId(recommandationRequest.getRecommendationId());
        recommandation.setProductId(recommandationRequest.getProductId());
        recommandationRepository.save(recommandation);
        return recommandation.getRecommendationId();
    }

    @Override
    public void updateLocation(long recommendationId,@RequestBody RecommandationRequest recommandationRequest) {

        Optional<Recommandation> recommandation1 = recommandationRepository.findById(recommendationId);
        if (recommandation1.isPresent()) {
            Recommandation recommandation2 = recommandation1.get();

            recommandation2.setAuthor(recommandationRequest.getAuthor());
            recommandation2.setRole(recommandationRequest.getRole());
            recommandation2.setContent(recommandationRequest.getContent());
            recommandation2.setProductId(recommandationRequest.getProductId());
            recommandation2.setRecommendationId(recommandationRequest.getRecommendationId());
            recommandationRepository.save(recommandation2);

        }

    }

    @Override
    public void deleteRecommendation(long recommendationId) {
        Optional<Recommandation> recommandation1 = recommandationRepository.findById(recommendationId);
        recommandation1.ifPresent(recommandation -> recommandationRepository.delete(recommandation));
    }

    @Override
    public List<RecommandationResponse> getAllRecommandation() {
        List<Recommandation> Recommendation = recommandationRepository.findAll();
        List<RecommandationResponse> recommendations = new ArrayList<>();
        for(Recommandation rec : Recommendation) {
            RecommandationResponse recommandationResponse = new RecommandationResponse();
            recommandationResponse.setAuthor(rec.getAuthor());
            recommandationResponse.setRole(rec.getRole());
            recommandationResponse.setContent(rec.getContent());
            recommandationResponse.setRecommendationId(rec.getRecommendationId());
            recommandationResponse.setProductId(rec.getProductId());
            recommendations.add(recommandationResponse);
        }
        return recommendations;
    }

    @Override
    public RecommandationResponse getRecommendationById(long recommendationId) {


        Optional<Recommandation> recommandation = recommandationRepository.findById(recommendationId);
        RecommandationResponse recommendationResponse = new RecommandationResponse();
        if (recommandation.isPresent()) {
            Recommandation Rec = recommandation.get();
            recommendationResponse.setAuthor(Rec.getAuthor());
            recommendationResponse.setRole(Rec.getRole());
            recommendationResponse.setProductId(Rec.getProductId());
            recommendationResponse.setRecommendationId(Rec.getRecommendationId());
            recommendationResponse.setContent(Rec.getContent());

        }else {
            throw new RecommndationNotFoundException("Recommendation with id = "+recommendationId+ " does not exist");
        }


        return recommendationResponse;
    }

    @Override
    public List<RecommandationResponse> getRecommendationByProductID(long id) {
        List<Recommandation>  recommandation = recommandationRepository.findAllByProductId(id);
        List<RecommandationResponse> recommandationResponses = new ArrayList<>();
        for(Recommandation rec : recommandation) {
            RecommandationResponse rs = new RecommandationResponse();
            rs.setAuthor(rec.getAuthor());
            rs.setRole(rec.getRole());
            rs.setContent(rec.getContent());
            rs.setRecommendationId(rec.getRecommendationId());
            rs.setProductId(rec.getProductId());
            recommandationResponses.add(rs);


        }
        return recommandationResponses;

    }
}
