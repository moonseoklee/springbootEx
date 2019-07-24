package com.example.demo.service.freeboardComment;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FreeboardComment;
import com.example.demo.repository.FreeboardCommentRepository;

@Service
public class FreeboardCommentListService {
	
	@Autowired
	private FreeboardCommentRepository freeboardCommentRepository;
	
	public List<FreeboardComment> getList(Long freeId){
		List<FreeboardComment> freeboardCommentList = freeboardCommentRepository.findAllByFreeId(freeId);
		
		LinkedList<FreeboardComment> CommentLinkedList = new LinkedList<FreeboardComment>(); 
		
        for (int i = 0; i < CommentLinkedList.size(); i++) {
            if (freeboardCommentList.get(i).getCommentLevel()==0) {//레벨 0 댓글들 먼저 연결리스트에 보관한다.
                CommentLinkedList.add(freeboardCommentList.get(i));//1개씩 추가한다.
            }
        }
        
        for (int i = 0; i < freeboardCommentList.size(); i++) {//댓글 전체를 돌면서
            if (freeboardCommentList.get(i).getCommentLevel()!=0) {//먼저 레벨이 0이 아닌것들을 거름
                //0이 아닌 것들을 걸렀다. -> 댓글에 달린 댓글들을 의미한다.
                Long originId = freeboardCommentList.get(i).getCommentOriginId();
                for (int j = 0; j < CommentLinkedList.size(); j++) {
                    if (CommentLinkedList.get(j).getCommentOriginId() == originId
                    		) {
                        CommentLinkedList.add(j+1, freeboardCommentList.get(i));
                    }
                }
            }             
        }

        return 	freeboardCommentList;

		
	}
}
