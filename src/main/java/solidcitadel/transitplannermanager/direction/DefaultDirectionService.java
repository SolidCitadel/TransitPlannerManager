package solidcitadel.transitplannermanager.direction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solidcitadel.transitplannermanager.direction.DTO.NewDirectionForm;
import solidcitadel.transitplannermanager.stop.Stop;
import solidcitadel.transitplannermanager.stop.JpaStopRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DefaultDirectionService implements DirectionService{

    private final JpaDirectionRepository directionRepository;
    private final JpaStopRepository stopRepository;

    @Transactional
    public void save(Direction direction) {
        directionRepository.save(direction);
    }

    public Direction findById(Long id) {
        return directionRepository.findById(id);
    }

    public List<Direction> findAll() {
        return directionRepository.findAll();
    }

    @Transactional
    public void create(NewDirectionForm newDirectionForm) {
        Stop departureStop = stopService.findById(newDirectionForm.getDepartureStopId());
        Stop arrivalStop = stopService.findById(newDirectionForm.getArrivalStopId());

        Direction direction = Direction.create(newDirectionForm.getName(),
                newDirectionForm.getFare(),
                newDirectionForm.getRequiredTime(),
                departureStop,
                arrivalStop);

        directionRepository.save(direction);
    }
}
