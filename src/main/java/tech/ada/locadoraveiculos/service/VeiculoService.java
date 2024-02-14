package tech.ada.locadoraveiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.locadoraveiculos.model.Veiculo;
import tech.ada.locadoraveiculos.repository.VeiculoRepository;
import tech.ada.locadoraveiculos.exception.VeiculoNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo criarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return this.veiculoRepository.findAll();
    }

    public Veiculo buscarVeiculoPorId(Long id) {

        Optional<Veiculo> optionalVeiculo = this.veiculoRepository.findById(id);
        if(optionalVeiculo.isPresent()) {
            return optionalVeiculo.get();
        } else {
            return null;
        }

    }


    public Veiculo alterarVeiculo(Veiculo veiculo) {

        Veiculo veiculoBD = this.buscarVeiculoPorId(veiculo.getId());

        Veiculo veiculoAlterado = new Veiculo();
        veiculoAlterado.setId(veiculoBD.getId());
        veiculoAlterado.setPlaca(veiculo.getPlaca());
        veiculoAlterado.setMarca(veiculo.getMarca());
        veiculoAlterado.setModelo(veiculo.getModelo());
        veiculoAlterado.setTipo(veiculo.getTipo());
        veiculoAlterado.setDisponivel(veiculo.getDisponivel());

        return this.veiculoRepository.save(veiculoAlterado);

    }

    public void deletarVeiculo(Long id) {
        Optional<Veiculo> optionalVeiculo = veiculoRepository.findById(id);
        if (optionalVeiculo.isPresent()) {
            veiculoRepository.delete(optionalVeiculo.get());
        } else {

            throw new VeiculoNotFoundException("Veículo não encontrado com o ID: " + id);
        }
    }


    public Veiculo buscarVeiculoPorPlaca(String placa) {
        return veiculoRepository.findByPlaca(placa);
    }

}