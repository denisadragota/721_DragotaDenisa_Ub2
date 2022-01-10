package Repository;

import Model.Bestellung;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BestellungRepository implements ICrudRepository<Bestellung> {

    private List<Bestellung> repoList;

    public BestellungRepository(){
        this.repoList = new ArrayList<>();
    }


    /**
     * @return all entities
     */
    @Override
    public List<Bestellung> findAll() {

        return this.repoList;
    }

    /**
     * @param id -the id of the entity to be returned id must not be null
     * @return the entity with the specified id or null - if there is no entity with the given id
     */
    @Override
    public Bestellung findOne(Long id) {


        for (Bestellung bestellung : this.repoList) {
            if (Objects.equals(bestellung.getId(), id))
                return bestellung;
        }
        return null;
    }


    /**
     * adding a Bestellung object to the repo list
     * first checking if already exist, then adding
     *
     * @param obj entity must be not null
     * @return null- if the given entity is saved otherwise returns the entity (id already exists)
     */
    @Override
    public Bestellung save(Bestellung obj) {



        /* if object already exists in the repo */
        if (this.findOne(obj.getId()) != null)
            return obj;

        /* add object */
        this.repoList.add(obj);
        return null;
    }

    /**
     * finds old instance with the same id as the new updated given object
     * removes the old instance and adds the updated one
     *
     * @param obj entity must not be null
     * @return null - if the entity is updated, otherwise returns the entity - (e.g id does not exist).
     */
    @Override
    public Bestellung update(Bestellung obj)  {

        /* find id of object to be updated */
        for(Bestellung bestellung: this.repoList){
            if(Objects.equals(bestellung.getId(), obj.getId())){
                bestellung.setBestellnr(obj.getBestellnr());
                bestellung.setAdresse(obj.getAdresse());
                bestellung.setProdukte(obj.getProdukte());

                return null;
            }
        }
        /* if object does not exist in the repo*/
        return obj;
    }

    /**
     * deletes object with given id from the repo list
     * first checks if id exists in the repoList, then delete
     *
     * @param id id must be not null
     * @return the removed entity or null if there is no entity with the given id
     */
    @Override
    public Bestellung delete(Long id) {


        /* if object does not exist in the repo */
        if (this.findOne(id) == null)
            return null;

        /*removing object with the given id */
        Bestellung toDelete = this.findOne(id);
        this.repoList.remove(toDelete);
        return toDelete;
    }
}
