/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Daniel Noriega
 */
public interface MedicoRepository extends JpaRepository<Medico, Long>{
    
}
