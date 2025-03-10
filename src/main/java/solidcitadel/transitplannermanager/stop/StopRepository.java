package solidcitadel.transitplannermanager.stop;

import java.util.*;

public interface StopRepository {
    Long save(Stop stop);

    Stop findById(Long id);

    List<Stop> findAll();
}
