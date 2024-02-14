package tech.ada.locadoraveiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tech.ada.locadoraveiculos.model.Veiculo;
import tech.ada.locadoraveiculos.service.VeiculoService;

import java.util.List;

@RestController //para API REST
//@Controller     //para MVC
@RequestMapping("/veiculo")
public class VeiculoRestController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/criar")
    public String criarVeiculo(@RequestBody Veiculo veiculo) {

        this.veiculoService.criarVeiculo(veiculo);

        return String.format("Veiculo com placa %s, criado com sucesso!", veiculo.getPlaca());
    }

    @GetMapping("/todos")
    public List<Veiculo> todos() {
        return this.veiculoService.listarTodos();
    }

    @GetMapping("por-id/{id}")
    public Veiculo buscarPorId(@PathVariable("id") Long id) {
        return this.veiculoService.buscarVeiculoPorId(id);
    }

    @PutMapping("/alterar")
    public Veiculo alterar(@RequestBody Veiculo veiculo) {
        return this.veiculoService.alterarVeiculo(veiculo);
    }

    @GetMapping("/por-placa/{placa}")
    public Veiculo buscarPorPlaca(@PathVariable("placa") String placa) {
        return this.veiculoService.buscarVeiculoPorPlaca(placa);
    }

    @DeleteMapping("/remover-por-id/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.veiculoService.deletarVeiculo(id);
        return String.format("Veiculo com id %d, removido com sucesso!");
    }


    /*
     * C - Creat - POST - Aceita Body
     * R - Read  - GET
     * U - Update - PUT - Aceita Body
     * D - Delete - DELETE
     * */

}