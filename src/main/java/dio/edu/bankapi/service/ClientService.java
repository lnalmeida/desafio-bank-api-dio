package dio.edu.bankapi.service;

import dio.edu.bankapi.domain.model.Client;
import dio.edu.bankapi.domain.repository.ClientRepository;
import dio.edu.bankapi.service.abstractiion.IUserService;
import dio.edu.bankapi.service.dto.ClientRequestDto;
import dio.edu.bankapi.service.dto.ClientResponseDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class UserService implements IUserService {

    @Autowired
    private final ClientRepository clientRepository;

    public UserService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientResponseDto findById(Long id) {
        return clientRepository.findById(id).map(c -> new ClientResponseDto(
                c.getId(),
                c.getCpf(),
                c.getName(),
                c.getAccount(),
                c.getCard(),
                c.getFeatures(),
                c.getNews()
        ))
        .orElseThrow(() -> new EntityNotFoundException("Client not found with id " + id));
    }

    @Override
    public ClientResponseDto findByCpf(String cpf) {
        return clientRepository.findByCpf(cpf).map(c -> new ClientResponseDto(
                        c.getId(),
                        c.getCpf(),
                        c.getName(),
                        c.getAccount(),
                        c.getCard(),
                        c.getFeatures(),
                        c.getNews()
                ))
                .orElseThrow(() -> new EntityNotFoundException("Client not found with cpf " + cpf));
    }

    @Override
    public ClientResponseDto findByAccountNumber(String accountNumber) {
        return clientRepository.findByAccountNumber(accountNumber).map(c -> new ClientResponseDto(
                        c.getId(),
                        c.getCpf(),
                        c.getName(),
                        c.getAccount(),
                        c.getCard(),
                        c.getFeatures(),
                        c.getNews()
                ))
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id " + accountNumber));
    }

    @Override
    public List<ClientResponseDto> findAll() {
        return clientRepository.findAll().stream().map(c -> new ClientResponseDto(
                c.getId(),
                c.getCpf(),
                c.getName(),
                c.getAccount(),
                c.getCard(),
                c.getFeatures(),
                c.getNews()
        ))
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponseDto CreateClient(ClientRequestDto client) {
        if(clientRepository.findByCpf(client.cpf()).isPresent()) {
            throw new IllegalArgumentException("Already a client with cpf " + client.cpf());
        }
        if(clientRepository.findByAccountNumber(client.account().getNumber()).isPresent()) {
            throw new IllegalArgumentException("Already a client with account number " + client.account().getNumber());
        }
        Client newClient = new Client();
        newClient.setCpf(client.cpf());
        newClient.setName(client.name());
        newClient.setAccount(client.account());
        newClient.setCard(client.card());
        newClient.setFeatures(client.features());
        newClient.setNews(client.news());

        clientRepository.save(newClient);

        return new ClientResponseDto(
                newClient.getId(),
                newClient.getCpf(),
                newClient.getName(),
                newClient.getAccount(),
                newClient.getCard(),
                newClient.getFeatures(),
                newClient.getNews()
        );
    }

    @Override
    public ClientResponseDto UpdateClient(Long id, ClientRequestDto client) {
        Client oldClient = clientRepository.findById(id).orElse(null);
        if(oldClient == null) throw new NotFoundException("Client not found with id " + id);
        oldClient.setCpf(client.cpf());
        oldClient.setName(client.name());
        oldClient.setAccount(client.account());
        oldClient.setCard(client.card());
        oldClient.setFeatures(client.features());
        oldClient.setNews(client.news());

        clientRepository.save(oldClient);

        return new ClientResponseDto(
                oldClient.getId(),
                oldClient.getCpf(),
                oldClient.getName(),
                oldClient.getAccount(),
                oldClient.getCard(),
                oldClient.getFeatures(),
                oldClient.getNews()
        );
    }

    @Override
    public String DeleteClientById(Long id) {
        if(clientRepository.findById(id).isEmpty()) {
            throw new NotFoundException("Client not found with id" + id);
        }
        clientRepository.deleteById(id);
        return "Client deleted";
    }
}
