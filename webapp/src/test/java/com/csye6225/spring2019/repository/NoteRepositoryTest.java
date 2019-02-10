package com.csye6225.spring2019.repository;


import com.csye6225.spring2019.entity.Account;
import com.csye6225.spring2019.entity.Note;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class NoteRepositoryTest {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserRepository userRepository;
    private int userId=0;
    @Test
    public void testInsertNewNote(){
        List<Account> accounts = userRepository.findAll();
        if(accounts==null || accounts.isEmpty()) {
            System.out.println("No user found");
            return;
        }
        userId = accounts.get(0).getId();
        Note note = new Note();
        note.setUserId(userId);
        note.setTitle("sdd");
        note.setContent("dsss");
        int re = noteRepository.insertNewNote(note);
        Assert.assertTrue(re==1);
        Assert.assertTrue(note.getId()>0);
    }

    @Test
    public void testListNoteByUserIdAndTitle(){
        testInsertNewNote();
        List<Note> notes = noteRepository.listNoteByUserIdAndTitle(userId,"d");
        Assert.assertTrue(notes!=null && !notes
        .isEmpty());
    }
    
}