package solidcitadel.tp.admin.api.direction;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import solidcitadel.tp.admin.api.direction.DTO.CreateDirectionRequest;
import solidcitadel.tp.admin.api.direction.DTO.DirectionDetailDTO;
import solidcitadel.tp.admin.api.direction.DTO.DirectionSummaryDTO;

import java.util.List;

@RestController
@RequestMapping("/api/directions")
@RequiredArgsConstructor
public class DirectionApiController {
    private final DirectionService directionService;

    @GetMapping
    public List<DirectionSummaryDTO> getStops() {
        return directionService.findAll().stream()
                .map(DirectionSummaryDTO::from)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createDirection(@RequestBody CreateDirectionRequest request) {
        return directionService.create(
                request.getFare(),
                request.getRequiredTime(),
                request.getDepartureStopId(),
                request.getArrivalStopId()
        );
    }

    @GetMapping("/{directionId}")
    public DirectionDetailDTO getDirectionDetail(@PathVariable("directionId") Long directionId) {
        return DirectionDetailDTO.from(directionService.findById(directionId));
    }

    @PutMapping("/{directionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDirection(@PathVariable("directionId") Long directionId, @RequestBody CreateDirectionRequest request) {
        directionService.update(
                directionId,
                request.getFare(),
                request.getRequiredTime(),
                request.getDepartureStopId(),
                request.getArrivalStopId()
        );
    }

    @DeleteMapping("/{directionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDirection(@PathVariable("directionId") Long directionId) {
        directionService.deleteById(directionId);
    }

}
