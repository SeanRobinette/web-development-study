package com.robinette.services.map;

import com.robinette.model.Visit;
import com.robinette.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit == null || visit.getPet() == null || visit.getPet().getId() == null ||
            visit.getPet().getOwner() == null) {
            throw new RuntimeException("Attempted to save invalid Visit");
        }
        return super.save(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void deleteByObject(Visit visit) {
        super.deleteByObject(visit);
    }
}
