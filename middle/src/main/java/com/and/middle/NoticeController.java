package com.and.middle;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import notice.NoticeVO;

@RestController
public class NoticeController {

	// ��������
	@Autowired
	@Qualifier("hanul")
	SqlSession sql;

	@RequestMapping(value = "/notice.no", produces = "text/html;charset=utf-8")
	public String notice() {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		List<NoticeVO> notice = sql.selectList("no.list");
		return gson.toJson(notice);
	}

	// �͸�Խ���
	@RequestMapping(value = "/secret.no", produces = "text/html;charset=utf-8")
	public String secret() {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		List<NoticeVO> secret = sql.selectList("no.se_list");

		return gson.toJson(secret);
	}

	// �͸�Խ��� �۾���
	@RequestMapping(value = "/insert.no", produces = "text/html;charset=utf-8")
	public String insert(String vo) {
		System.out.println(vo);
		NoticeVO temp_vo = new Gson().fromJson(vo, NoticeVO.class);
		int cnt = sql.insert("no.se_insert", temp_vo);
		return new Gson().toJson(cnt).toString();
	}

	// �������� �۾���
	@RequestMapping(value = "/noinsert.no", produces = "text/html;charset=utf-8")
	public String noinsert(String vo) {
		NoticeVO temp_vo = new Gson().fromJson(vo, NoticeVO.class);
		int cnt = sql.insert("no.se_insert", temp_vo);
		return new Gson().toJson(cnt).toString();
	}

	// �͸�Խ��� ����
	@RequestMapping("/secupdate.no")
	public String secupdate(String no) {
		NoticeVO temp_vo = new Gson().fromJson(no, NoticeVO.class);
		int cnt = sql.update("no.update", temp_vo);
		return new Gson().toJson(cnt).toString();
		
	}
	

	// �������� ����
	@RequestMapping(value = "/info.no", produces = "text/html;charset=utf-8")
	public String noticeinfo(String no) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		NoticeVO vo = sql.selectOne("no.no_info", no);
		sql.update("no.hits", no);
		return gson.toJson(vo);
	}

	// �͸�Խ��� ����
	@RequestMapping(value = "/secinfo.no", produces = "text/html;charset=utf-8")
	public String secretinfo(String no) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		NoticeVO vo = sql.selectOne("no.no_info", no);
		sql.update("no.hits", no);
		return gson.toJson(vo);
	}

	// �������� / �͸�Խ��� �ۻ���
	@RequestMapping(value = "/delete.no", produces = "text/html;charset=utf-8")
	public void nodelete(int board_no) {
		sql.delete("no.delete", board_no);
	}

}
