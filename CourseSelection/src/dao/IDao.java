package dao;
import java.util.HashMap;
import entity.IEntity;;

public interface IDao {
	void insert(IEntity ientity); //增加
	void delete();  //删除
	void update();  //修改
	public HashMap<String, IEntity> getAllEntities();  //获取全部实体
	public IEntity getEntity(String Id); //获取某个实体，即查询
}