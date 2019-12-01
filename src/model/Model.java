package model;

public abstract class Model {
	public static String table_name;
	
	public abstract void create(Model t);
	public abstract void update(Model t);
	public abstract void delete(Model t);
	
}
