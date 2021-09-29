
package com.diegopatzan.models.idao;

import com.diegopatzan.models.domain.Instructor;
import java.util.List;

/**
 *
 * @author Axel Javier Guadalupe Alvarez Felipe
 */
public interface IInstructorDao {
    public List<Instructor> listar();
    
    public Instructor encontrar(Instructor instructor);
    public int insertar(Instructor instructor);
    public int actualizar(Instructor instructor);
    public int eliminar(Instructor instructor);
    
}
