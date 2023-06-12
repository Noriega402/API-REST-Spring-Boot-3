/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.medico.DatosListadoMedico;
import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *
 * @author Daniel Noriega
 */
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    // NOTA: no es recomendable usar Autowired para pruebas unitarias
    @Autowired
    private MedicoRepository medicoRepository;
    
    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico){
        //System.out.println("El request llego de manera correcta");
        //System.out.println(datosRegistroMedico);
        medicoRepository.save(new Medico(datosRegistroMedico));
    }

    // mostar listado sin paginacion
    /*@GetMapping
    public List<DatosListadoMedico> listadoMedicos(){
        return medicoRepository.findAll().stream().map(DatosListadoMedico::new).toList();
    }*/

    //Mostrar listado con paginacion
    @GetMapping
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size = 2) Pageable paginacion){
        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
    }

    //@PageableDefault(size = 2) dar un valor por defecto de cuantos items se muestran por paginacion
}
