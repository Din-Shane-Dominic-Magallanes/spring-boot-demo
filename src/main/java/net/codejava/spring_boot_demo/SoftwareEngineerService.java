package net.codejava.spring_boot_demo;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    @PostConstruct
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public void initData() {
        softwareEngineerRepository.save(new SoftwareEngineer(null, "Din", "kbd, databases, q"));
        softwareEngineerRepository.save(new SoftwareEngineer(null, "Allana", "java, spring boot, spring"));
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id+" not found"));
    }

    public void putSoftwareEngineer(Integer id, SoftwareEngineer updatedsoftwareEngineer) {
        SoftwareEngineer existingsoftwareEngineer = softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id+" not found"));

            existingsoftwareEngineer.setName(updatedsoftwareEngineer.getName());
            existingsoftwareEngineer.setTechStack(updatedsoftwareEngineer.getTechStack());

            softwareEngineerRepository.save(existingsoftwareEngineer);
    }

    public void removeSoftwareEngineer(Integer id) {
        softwareEngineerRepository.findById(id);
    }
}
