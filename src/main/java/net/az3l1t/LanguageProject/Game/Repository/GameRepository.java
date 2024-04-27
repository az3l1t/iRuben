package net.az3l1t.LanguageProject.Game.Repository;

import net.az3l1t.LanguageProject.Game.Model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
}
