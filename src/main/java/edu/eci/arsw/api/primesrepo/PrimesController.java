package edu.eci.arsw.api.primesrepo;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeService;
import edu.eci.arsw.api.primesrepo.service.PrimeServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
@RestController
public class PrimesController
{

    @Autowired
    @Qualifier("PrimeService")
    PrimeService primeService;


    @RequestMapping( value = "/primes", method = GET )
    public ResponseEntity<?> getPrimes() throws PrimeServiceException {
        try {
            return new ResponseEntity<>(primeService.getFoundPrimes(), HttpStatus.ACCEPTED);
        }
        catch(PrimeServiceException e){
            throw new PrimeServiceException("No hay numeros primos",e);
        }
    }

    @RequestMapping( value = "/primes/{primenumber}", method = GET )
    public ResponseEntity<?> getPrime(@PathVariable String prime) throws PrimeServiceException {
        try {
            return new ResponseEntity<>(primeService.getPrime(prime), HttpStatus.ACCEPTED);
        }
        catch(PrimeServiceException e){
            throw new PrimeServiceException("El numero primo no existe",e);
        }
    }

    @RequestMapping( value = "/primes", method = POST )
    public ResponseEntity<?> manejadorCrearPrimos(@RequestBody FoundPrime foundPrime)  throws PrimeServiceException {
        try {
            primeService.addFoundPrime(foundPrime);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PrimeServiceException e) {
            throw new PrimeServiceException("El numero ya existe",e);
        }

    }







}
