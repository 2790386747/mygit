package dao;
import java.util.HashMap;
import entity.IEntity;;

public interface IDao {
	void insert(IEntity ientity); //����
	void delete();  //ɾ��
	void update();  //�޸�
	public HashMap<String, IEntity> getAllEntities();  //��ȡȫ��ʵ��
	public IEntity getEntity(String Id); //��ȡĳ��ʵ�壬����ѯ
}