package tn.esprit.kaddemproject.services;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.kaddemproject.entities.Contrat;
import tn.esprit.kaddemproject.entities.Etudiant;
import tn.esprit.kaddemproject.entities.Option;
import tn.esprit.kaddemproject.entities.Specialite;
import tn.esprit.kaddemproject.generic.BaseRepository;
import tn.esprit.kaddemproject.generic.IGenericServiceImp;
import tn.esprit.kaddemproject.repositories.ContratRepository;
import tn.esprit.kaddemproject.repositories.EtudiantRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@Slf4j
@DataJpaTest

public class IContratServiceImpTest  {
    @Mock
    private ContratRepository contratRepository;

    @Mock
    private EtudiantRepository etudiantRepository;
@Mock
private BaseRepository baseRepository;
    Contrat contrat = new Contrat(1, LocalDate.of(2023, 11, 4), LocalDate.of(2023, 11, 4), Specialite.IA, true, 50);
    List<Contrat> contratList=new ArrayList<Contrat>()
    {
        {
           add(new Contrat(1, LocalDate.of(2023, 11, 4), LocalDate.of(2023, 11, 4), Specialite.IA, true, 50));
        add (new Contrat(2, LocalDate.of(2023, 11, 4), LocalDate.of(2023, 11, 4), Specialite.IA, true, 50));

        }
    };
    @InjectMocks
    private IContratServiceImp iContratServiceImp;

    @InjectMocks
    private IEtudiantServiceImp iEtudiantServiceImp;

    @Test
    public void retrieveAllPistesTest() {
        Mockito.when(baseRepository.findAll()).thenReturn(contratList);
        List<Contrat> allcontats = iContratServiceImp.retrieveAll();
        Assertions.assertTrue(!allcontats.isEmpty());
        Assertions.assertEquals(contratList.size(), allcontats.size());
    }

    @Test
    public void removecontrattest() {
        Integer numcont = 1;

        // Mock the deleteById method on baseRepository
        Mockito.doNothing().when(baseRepository).deleteById(numcont);
        Mockito.when(baseRepository.existsById(Mockito.any(Integer.class))).thenReturn(true);

        // Call the delete method from your service
        iContratServiceImp.delete(numcont);

        // Verify that deleteById was called with the expected argument
        Mockito.verify(baseRepository, Mockito.times(1)).deleteById(numcont);
        Assertions.assertFalse(contratList.contains(contrat));
    }
    @Test
    public void addcontrattest() {

        Mockito.when(baseRepository.save(Mockito.any(Contrat.class))).thenReturn(contrat);

        Contrat addcontact = iContratServiceImp.add(contrat);
        Assertions.assertEquals(contrat, addcontact);
    }


}
