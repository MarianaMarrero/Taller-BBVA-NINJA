package uy.com.bbva.services.template.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.com.bbva.services.commons.dao.ManagerDataAccessSQL;
import uy.com.bbva.services.commons.dao.SQLDataBase;
import uy.com.bbva.services.commons.exceptions.ServiceException;
import uy.com.bbva.services.commons.utils.LogUtils;
import uy.com.bbva.services.template.model.Training;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TrainingDAOImpl implements TrainingDAO {

    private final String SQL_TARININGS_BY_EMPLOYEE = "select training.id, training.name FROM training JOIN employee_training"
            + "  ON employee_training.id_training = training.id JOIN employee"
            + " ON employee.id = employee_training.id_employee where employee.id = ?";

    @Autowired
    private ManagerDataAccessSQL managerSQL;

    @Autowired
    private LogUtils logger;

    @Override
    public List<Training> getTrainingsByEmployee(final Long id) throws ServiceException {

        final List<Training> trainings = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = managerSQL.prepareStatement(SQL_TARININGS_BY_EMPLOYEE,
                    SQLDataBase.CHARRUA);

            preparedStatement.setLong(1, id);
            resultSet = managerSQL.executeQuery(preparedStatement);

            while (resultSet.next()) {
                final Training training = new Training();
                training.setId(resultSet.getInt(1));
                training.setName(resultSet.getString(2));
                trainings.add(training);
            }

            return trainings;

        } catch (SQLException sqlException) {

            /***************************************************************************************
             NO UTILIZAR NUNCA logger.logError.
             Este ejemplo es para comprender cómo se usa el logger dentro de las apis commons

             logger.logError(this.getClass().getName(),
             "logError", "logError");
             ***************************************************************************************/
            /***************************************************************************************
             USO CORRECTO:  Usar throw new ServiceException(...)
             ***************************************************************************************/
            throw new ServiceException("problema de conexión a la base de datos", "No se pudo conectar a la base de datos", sqlException);

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

                throw new ServiceException("Problema de conexión a la base de datos", "No se pudo cerrar la conexión a la base de datos", sqlException);
            }
        }
    }
}
