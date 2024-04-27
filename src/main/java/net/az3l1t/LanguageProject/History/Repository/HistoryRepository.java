package net.az3l1t.LanguageProject.History.Repository;

import net.az3l1t.LanguageProject.History.Model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
