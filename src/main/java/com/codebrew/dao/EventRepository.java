import com.codebrew.models.Events


public interface EventRepository extends JpaRepository<Events, Long> {
    Events findByEventId(Integer id);
