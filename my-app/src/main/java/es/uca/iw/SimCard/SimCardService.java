package es.uca.iw.SimCard;

import es.uca.iw.Cliente.Cliente;
import es.uca.iw.Tarifa;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SimCardService {
    private final SimCardRepository simCardRepository;

    @Autowired
    public SimCardService(SimCardRepository simCardRepository) {
        this.simCardRepository = simCardRepository;
    }

    @Transactional
    public SimCard createSimCard(Integer number, Tarifa tarifa, Cliente cliente) {
        SimCard simCard = new SimCard();
        simCard.setNumber(number);
        simCard.setTarifa(tarifa);
        simCard.setCliente(cliente);
        simCard.setActive(true);
        return simCardRepository.save(simCard);
    }

    @Transactional
    public Optional<SimCard> getSimCardByNumber(Integer number) {
        return simCardRepository.findByNumber(number);
    }

    @Transactional
    public Optional<SimCard> getSimCardsByCliente(Cliente cliente) {
        return simCardRepository.findByCliente(cliente);
    }

    @Transactional
    public List<SimCard> getAllSimCards() {
        return simCardRepository.findAll();
    }

    @Transactional
    public void deactivateSimCard(Integer number) {
        Optional<SimCard> optionalSimCard = simCardRepository.findByNumber(number);

        if (optionalSimCard.isPresent()) {
            SimCard simCard = optionalSimCard.get();
            simCard.setActive(false);
            simCardRepository.save(simCard);
        }
    }

    @Transactional
    public void addUsedMinutes(Integer number, int minutesToAdd) {
        Optional<SimCard> optionalSimCard = simCardRepository.findByNumber(number);

        if (optionalSimCard.isPresent()) {
            SimCard simCard = optionalSimCard.get();
            simCard.setUsedMinutes(simCard.getUsedMinutes() + minutesToAdd);
            simCardRepository.save(simCard);
        }
    }

    @Transactional
    public void addUsedMb(Integer number, int mbToAdd) {
        Optional<SimCard> optionalSimCard = simCardRepository.findByNumber(number);

        if (optionalSimCard.isPresent()) {
            SimCard simCard = optionalSimCard.get();
            simCard.setUsedMb(simCard.getUsedMb() + mbToAdd);
            simCardRepository.save(simCard);
        }
    }

    @Transactional
    public void addUsedSms(Integer number, int smsToAdd) {
        Optional<SimCard> optionalSimCard = simCardRepository.findByNumber(number);

        if (optionalSimCard.isPresent()) {
            SimCard simCard = optionalSimCard.get();
            simCard.setUsedSms(simCard.getUsedSms() + smsToAdd);
            simCardRepository.save(simCard);
        }
    }

    @Transactional
    public void resetUsage(Integer number) {
        Optional<SimCard> optionalSimCard = simCardRepository.findByNumber(number);

        if (optionalSimCard.isPresent()) {
            SimCard simCard = optionalSimCard.get();
            simCard.setUsedMinutes(0);
            simCard.setUsedMb(0);
            simCard.setUsedSms(0);
            simCardRepository.save(simCard);
        }
    }
}