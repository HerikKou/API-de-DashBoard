package DashBoard.DashBoard;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import DashBoard.DashBoard.Model.Dashboard;
import DashBoard.DashBoard.Repository.DashRepository;
import DashBoard.DashBoard.Service.DashBoardService;

@SpringBootTest
@ActiveProfiles("test")
class DashBoardApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public String deveRetornarNomeDoMetodo() {
		return "deveRetornarNomeDoMetodo";
	}
	@Test
	public void deveRetornarProfissaoComMaisFuncionarios() {
		DashRepository repository = Mockito.mock(DashRepository.class);
		DashBoardService service = new DashBoardService(repository);
		Dashboard dash1 = new Dashboard();
		dash1.setProfissao("Engenheiro");
		Dashboard dash2 = new Dashboard();
		dash2.setProfissao("Engenheiro");
		Dashboard dash3 = new Dashboard();
		dash3.setProfissao("Médico");
		Mockito.when(repository.findAll()).thenReturn(List.of(dash1, dash2, dash3));
		List<Dashboard> result = service.profissaoComMaisFuncionarios();
		assert(result.size() == 2);
		assert(result.get(0).getProfissao().equals("Engenheiro"));
		assert(result.get(1).getProfissao().equals("Engenheiro"));
		assert(!result.get(0).getProfissao().equals("Médico"));

	}

}
