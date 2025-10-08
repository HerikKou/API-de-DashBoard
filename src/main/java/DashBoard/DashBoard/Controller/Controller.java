package DashBoard.DashBoard.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DashBoard.DashBoard.DTO.DashBoardDTO;
import DashBoard.DashBoard.Model.Dashboard;
import DashBoard.DashBoard.Service.DashBoardService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/dashboard")
public class Controller {
    private final DashBoardService service;
    public Controller(DashBoardService service) {
        this.service = service;
    }
    @PostMapping("/register")
    public ResponseEntity<Dashboard> register(@RequestBody DashBoardDTO dto) {
        Dashboard dash = service.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dash);
    }
    @GetMapping("/profissao")
    public ResponseEntity<List<Dashboard>> profissaoComMaisFuncionarios() {
        List<Dashboard> result = service.profissaoComMaisFuncionarios();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/cidade")
    public ResponseEntity<List<Dashboard>> cidadeComMaisFuncionarios() {
        List<Dashboard> result = service.cidadeComMaisFuncionarios();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/estadoComMaisFuncionarios")
    public ResponseEntity<List<Dashboard>> estadoComMaisFuncionarios() {
        List<Dashboard> result = service.estadoComMaisFuncionarios();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/salarioMedio")
    public ResponseEntity<Double> salarioMedio() {
        double result = service.salarioMedio();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/salarioMedioPorCidade/{cidade}")
    public ResponseEntity<Double> salarioMedioPorCidade(@PathVariable String cidade) {
        double result = service.salarioMedioPorCidade(cidade);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/totalFuncionariosPorPais")
    public ResponseEntity<List<Dashboard>> totalFuncionariosPais() {
         List<Dashboard> result = service.totalDefuncionariosPorPais();
        return ResponseEntity.ok(result);
    }
    
}
