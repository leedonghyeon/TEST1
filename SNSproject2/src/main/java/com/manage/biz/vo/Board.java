package com.manage.biz.vo;

public class Board {
	int board_no;
	String board_writer;
	String board_contents;
	String board_date;
	String board_time;
	String diff_time;
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_contents() {
		return board_contents;
	}
	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	public String getBoard_time() {
		return board_time;
	}
	public void setBoard_time(String board_time) {
		this.board_time = board_time;
	}
	public String getDiff_time() {
		return diff_time;
	}
	public void setDiff_time(String diff_time) {
		this.diff_time = diff_time;
	}
	
}
