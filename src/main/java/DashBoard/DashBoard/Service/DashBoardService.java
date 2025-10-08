package DashBoard.DashBoard.Service;
import DashBoard.DashBoard.DTO.DashBoardDTO;
import DashBoard.DashBoard.Model.Dashboard;
import DashBoard.DashBoard.Repository.DashRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.*;

@Service
public class DashBoardService {
    private final DashRepository dashRepository;
    public DashBoardService(DashRepository dashRepository) {
        this.dashRepository = dashRepository;
    }
    public Dashboard register(DashBoardDTO dto) {
           var dash = new Dashboard();
           dash.setName(dto.getName());
           dash.setIdade(dto.getIdade()); 
           dash.setEstado(dto.getEstado());
           dash.setCidade(dto.getCidade());
           dash.setProfissao(dto.getProfissao());
           dash.setSalario(dto.getSalario());
          return dashRepository.save(dash);           
            
    }
   public List<Dashboard> profissaoComMaisFuncionarios() {
        List<Dashboard> dashboards = dashRepository.findAll();
        Map<String, Long> profissaoCount = dashboards.stream()
                .collect(Collectors.groupingBy(Dashboard::getProfissao, Collectors.counting()));
        Long maxCount = profissaoCount.values().stream().max(Long::compare).orElse(0L);
        return dashboards.stream()
                .filter(d -> profissaoCount.get(d.getProfissao()).equals(maxCount))
                .collect(Collectors.toList());
    }
    public List<Dashboard> cidadeComMaisFuncionarios() {
        List<Dashboard> dashboards = dashRepository.findAll();
        Map<String, Long> cidadeCount = dashboards.stream()
                .collect(Collectors.groupingBy(Dashboard::getCidade, Collectors.counting()));
        Long maxCount = cidadeCount.values().stream().max(Long::compare).orElse(0L);
        return dashboards.stream()
                .filter(d -> cidadeCount.get(d.getCidade()).equals(maxCount))
                .collect(Collectors.toList());
    }
    public List<Dashboard> estadoComMaisFuncionarios() {
        List<Dashboard> dashboards = dashRepository.findAll();
        Map<String, Long> estadoCount = dashboards.stream()
                .collect(Collectors.groupingBy(Dashboard::getEstado, Collectors.counting()));
        Long maxCount = estadoCount.values().stream().max(Long::compare).orElse(0L);
        return dashboards.stream()
                .filter(d -> estadoCount.get(d.getEstado()).equals(maxCount))
                .collect(Collectors.toList());
    }
    public double salarioMedio() {
        List<Dashboard> dashboards = dashRepository.findAll();
        return dashboards.stream()
                .mapToDouble(Dashboard::getSalario)
                .average()
                .orElse(0.0);
    }
    public double salarioMedioPorProfissao(String profissao) {
        List<Dashboard> dashboards = dashRepository.findAll();
        return dashboards.stream()
                .filter(d -> d.getProfissao().equalsIgnoreCase(profissao))
                .mapToDouble(Dashboard::getSalario)
                .average()
                .orElse(0.0);
    }
    public double salarioMedioPorCidade(String cidade) {
        List<Dashboard> dashboards = dashRepository.findAll();
        return dashboards.stream()
                .filter(d -> d.getCidade().equalsIgnoreCase(cidade))
                .mapToDouble(Dashboard::getSalario)
                .average()
                .orElse(0.0);
    }
    public double salarioMedioPorEstado(String estado) {
        List<Dashboard> dashboards = dashRepository.findAll();
        return dashboards.stream()
                .filter(d -> d.getEstado().equalsIgnoreCase(estado))
                .mapToDouble(Dashboard::getSalario)
                .average()
                .orElse(0.0);
    }
    public List<Dashboard> todosFuncionarios() {
        return dashRepository.findAll();
    }
    public List<Dashboard> totalDefuncionariosPorPais(){
        List<Dashboard> dashboards = dashRepository.findAll();
        Map<String, Long> paisCount = dashboards.stream()
                .collect(Collectors.groupingBy(Dashboard::getPais, Collectors.counting()));
        Long maxCount = paisCount.values().stream().max(Long::compare).orElse(0L);
        return dashboards.stream().filter(p-> p.getPais().equalsIgnoreCase(p.getPais())).collect(Collectors.toList());
    }

}
