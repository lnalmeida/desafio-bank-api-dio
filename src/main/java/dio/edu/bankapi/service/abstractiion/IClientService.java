package dio.edu.bankapi.service.abstractiion;

import dio.edu.bankapi.service.dto.*;

import java.util.List;

public interface IUserService {
    ClientResponseDto findById(Long id);
    ClientResponseDto findByCpf(String cpf);
    ClientResponseDto findByAccountNumber(String accountNumber);
    List<ClientResponseDto> findAll();
    ClientResponseDto CreateClient(ClientRequestDto client);
    ClientResponseDto UpdateClient(Long id, ClientRequestDto client);
    String DeleteClientById(Long id);
}
