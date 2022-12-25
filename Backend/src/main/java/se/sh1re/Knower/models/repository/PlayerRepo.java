package se.sh1re.Knower.models.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.sh1re.Knower.models.model.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long> {
}
