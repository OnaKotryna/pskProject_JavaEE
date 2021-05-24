package okk.pskProject_JavaEE.persistence;

import okk.pskProject_JavaEE.entities.RecordLabel;

import java.util.List;

public interface IRecordLabelDAO {

    public List<RecordLabel> loadAll();

    public void persist(RecordLabel recordLabel);

    public RecordLabel findOne(Integer id);
}
