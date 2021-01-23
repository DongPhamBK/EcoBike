package com.ebr.components.abstractdata.controller;

// interface giu nguyen
// co tac dung trong khoi tao interface
public interface IDataManageController<T> {
	public void create(T t);
	public void read(T t);
	public void delete(T t);
	public void update(T t);
}
