package DashBoard.DashBoard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import DashBoard.DashBoard.Model.Dashboard;

public interface DashRepository extends JpaRepository<Dashboard, Long> {

    
}
