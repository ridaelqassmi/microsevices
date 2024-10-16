package com.elqassmi.dao;

import com.elqassmi.domain.ProductRecommendationKey;
import com.elqassmi.domain.Recommandation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommandationRepository extends JpaRepository<Recommandation, ProductRecommendationKey> {
    public Recommandation findByProductId(long id);


}
