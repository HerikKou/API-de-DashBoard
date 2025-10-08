package DashBoard.DashBoard;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import DashBoard.DashBoard.Model.Dashboard;
import DashBoard.DashBoard.Repository.DashRepository;
import DashBoard.DashBoard.Service.DashBoardService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class DashBoardApplicationTests {

    @Test
    void contextLoads() {
        // Testa apenas se o contexto do Spring Boot carrega corretamente
        assertTrue(true);
    }

    @Test
    void deveRetornarNomeDoMetodo() {
        String nome = "deveRetornarNomeDoMetodo";
        assertEquals("deveRetornarNomeDoMetodo", nome);
    }

    @Test
    void deveRetornarProfissaoComMaisFuncionarios() {
        // Mock do repository
        DashRepository repository = Mockito.mock(DashRepository.class);
        DashBoardService service = new DashBoardService(repository);

        // Simula dados no banco
        Dashboard dash1 = new Dashboard();
        dash1.setProfissao("Engenheiro");
        Dashboard dash2 = new Dashboard();
        dash2.setProfissao("Engenheiro");
        Dashboard dash3 = new Dashboard();
        dash3.setProfissao("Médico");

        Mockito.when(repository.findAll()).thenReturn(List.of(dash1, dash2, dash3));

        // Executa o método
        List<Dashboard> result = service.profissaoComMaisFuncionarios();

        // Validações
        assertEquals(2, result.size());
        assertEquals("Engenheiro", result.get(0).getProfissao());
        assertEquals("Engenheiro", result.get(1).getProfissao());
        assertNotEquals("Médico", result.get(0).getProfissao());
    }
}
