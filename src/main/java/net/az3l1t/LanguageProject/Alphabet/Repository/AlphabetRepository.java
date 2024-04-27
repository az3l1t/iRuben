package net.az3l1t.LanguageProject.Alphabet.Repository;

import net.az3l1t.LanguageProject.Alphabet.Model.Alphabet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlphabetRepository extends JpaRepository<Alphabet,Long> {
}
