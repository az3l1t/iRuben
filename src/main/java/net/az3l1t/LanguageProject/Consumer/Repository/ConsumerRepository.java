package net.az3l1t.LanguageProject.Consumer.Repository;

import net.az3l1t.LanguageProject.Consumer.Model.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ConsumerRepository extends JpaRepository<Consumer,Long> {
    @Query("SELECT s FROM Consumer s WHERE s.email = ?1")
    Optional<Consumer> findConsumerByEmail(String email);

}
