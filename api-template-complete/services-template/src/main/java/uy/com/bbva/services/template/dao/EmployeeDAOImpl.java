package uy.com.bbva.services.template.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.com.bbva.services.commons.dao.ManagerDataAccessSQL;
import uy.com.bbva.services.commons.dao.SQLDataBase;
import uy.com.bbva.services.commons.exceptions.ServiceException;
import uy.com.bbva.services.template.model.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class EmployeeDAOImpl implements EmployeeDAO{

    private final String FindEmployeeById = "select * FROM employee where employee.id = ?";

    @Autowired
    private ManagerDataAccessSQL managerSQL;

    @Override
    public Employee findEmployeeById(final Long id) throws ServiceException {


        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Employee employee =new Employee();

        try {
            preparedStatement = managerSQL.prepareStatement(FindEmployeeById,
                    SQLDataBase.CHARRUA);

            preparedStatement.setLong(1, id);
            resultSet = managerSQL.executeQuery(preparedStatement);

            while (resultSet.next()) {

                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));

            }
            return employee;

        } catch (SQLException sqlException) {

            throw new ServiceException("logError", "logError", sqlException);

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    managerSQL.close(preparedStatement);
                    managerSQL.closeConnection(SQLDataBase.CHARRUA);
                }
            } catch (SQLException sqlException) {

                throw new ServiceException("", "", sqlException);
            }
        }
    }
}
