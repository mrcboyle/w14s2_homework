package com.example.codeclan.filesandfolders.components;

import com.example.codeclan.filesandfolders.models.File;
import com.example.codeclan.filesandfolders.models.Folder;
import com.example.codeclan.filesandfolders.models.Person;
import com.example.codeclan.filesandfolders.repository.FileRepository;
import com.example.codeclan.filesandfolders.repository.FolderRepository;
import com.example.codeclan.filesandfolders.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    PersonRepository personRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) {

        Person chris = new Person("Chris");
        personRepository.save(chris);

        Folder folderA = new Folder("Folder_A", chris);
        folderRepository.save(folderA);

        File file1 = new File("file_1", ".jpeg", 101981, folderA);
        File file2 = new File("file_2", ".jpeg", 123232, folderA);
        File file3 = new File("file_3", ".jpeg", 165278, folderA);
        File file4 = new File("file_4", ".jpeg", 213451, folderA);
        fileRepository.save(file1);
        fileRepository.save(file2);
        fileRepository.save(file3);
        fileRepository.save(file4);

        chris.addFolder(folderA);
        personRepository.save(chris);
        folderA.addFile(file1);
        folderRepository.save(folderA);

    }
}
