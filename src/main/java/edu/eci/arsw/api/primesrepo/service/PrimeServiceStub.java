package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */

@Service("PrimeService")
public class PrimeServiceStub implements PrimeService {

    List<FoundPrime> listaPrimos = new CopyOnWriteArrayList<>();

    public PrimeServiceStub(){
        listaPrimos.add(new FoundPrime("carlos","5"));
    }

    @Override
    public void addFoundPrime( FoundPrime foundPrime ) throws PrimeServiceException{
        if (listaPrimos.contains(foundPrime)){
            throw new PrimeServiceException("El numero ya existe");
        }
        else{listaPrimos.add(foundPrime);}
    }

    @Override
    public List<FoundPrime> getFoundPrimes() throws PrimeServiceException{
        if (listaPrimos.size()==0){
            throw new PrimeServiceException("No hay numeros primos");
        }
        return listaPrimos;
    }

    @Override
    public FoundPrime getPrime( String prime ) throws PrimeServiceException{
        for (int i=0; i< listaPrimos.size();i++){
            if (listaPrimos.get(i).getPrime().equals(prime)){
                return listaPrimos.get(i);
            }
        }
        throw new PrimeServiceException("El numero primo no existe");
    }
}
