package com.example.aerquality.service.impl;

import com.example.aerquality.model.dto.CourseDto;
import com.example.aerquality.model.dto.UserDto;
import com.example.aerquality.model.entity.CourseEntity;
import com.example.aerquality.repository.CourseRepository;
import com.example.aerquality.service.CourseService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public CourseServiceImpl(CourseRepository courseRepository, ModelMapper modelMapper, Gson gson) {
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }


    @Override
    public List<CourseEntity> getAllCourses() {
        return this.courseRepository.findAll();
    }

    @Override
    public CourseEntity getById(long id) {
        return this.courseRepository.findById(id).get();
    }

    @Override
    public void addCourse(String course) {
        CourseDto courseDto = this.gson.fromJson(course, CourseDto.class);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(courseDto.getExamDate(), df);

        CourseEntity courseEntity = this.modelMapper.map(courseDto, CourseEntity.class);
        courseEntity.setExamDate(date);

        this.courseRepository.save(courseEntity);

    }

    @Override
    public void initCourses() {
        if (courseRepository.count()!=0){
            return;
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse("2021-11-21", df);

        this.courseRepository.save(new CourseEntity(
                "\n" +
                        "Art Gallery “Vladimir Dimitrov – Maystora” – town of Kyustendil",
                4,
                "The Art Gallery “Vladimir Dimitrov – Maystora” in Kyustendil was established in 1972 in honor of the 90th anniversary of the renowned artist. The building occupies an area of 4,200 square meters and has seven exposition halls with natural upper lighting.\n" +
                        "Vladimir Dimitrov – Maystora (The Master) (1882 – 1960) is one of the most renowned Bulgarian artists. Its specific style can not be mistaken – his paintings are exceptionally impressive with their vivid colors and unique painting style.\n" +
                        "The artist was born in the Kyustendil village of Frolosh in 1882. He studies in Kyustendil and passed through a number of professions until the local people noticed his incredible talent and helped him go and study in the Arts School (which is presently an academy) in Sofia. His first exhibition was opened on 21 May 1903 in the halls of the Regional Court in Kyustendil, when he was 21 years old and he worked as a clerk in court. In 1923, the Maystor settled in the village of Shishkovtsi, where he stayed for about 30 years, and a group of talented Bulgarian artists gathered around him – Boris Eliseev, Nikolay Dyulgerov, Kiril Tsonev, etc. A large part of his paintings were portraits and landscapes. Nature occupies a central place in the canvases of the Maystor, where he portrays it with wide strokes and hues of color close in tone.\n" +
                        "The permanent exposition of the art gallery in Kyustendil contains more than 100 masterpieces made by Vladimir Dimitrov – Maystrora. In the other halls, visitors can see exhibitions of works of art of the Kyustendil painting school and artists from the country and abroad.\n" +
                        "The gallery is often a host to various cultural events – concerts, recitals, book premiers, contests, artistic meetings, etc.\n" +
                        "Visitors of the Art Gallery “Vladimir Dimitrov – Maystora” can purchase postcards, books and catalogues containing reproductions of the most emblematic works of the artist.",
                "http://www.auction-rakursi.com/img_m14/011.jpg",
                date
        ));
        this.courseRepository.save(new CourseEntity(
                "The Art & Science of Figure Drawing: GESTURE",
                8,
                "The Art Gallery “Vladimir Dimitrov – Maystora” in Kyustendil was established in 1972 in honor of the 90th anniversary of the renowned artist. The building occupies an area of 4,200 square meters and has seven exposition halls with natural upper lighting.\n" +
                        "Vladimir Dimitrov – Maystora (The Master) (1882 – 1960) is one of the most renowned Bulgarian artists. Its specific style can not be mistaken – his paintings are exceptionally impressive with their vivid colors and unique painting style.\n" +
                        "The artist was born in the Kyustendil village of Frolosh in 1882. He studies in Kyustendil and passed through a number of professions until the local people noticed his incredible talent and helped him go and study in the Arts School (which is presently an academy) in Sofia. His first exhibition was opened on 21 May 1903 in the halls of the Regional Court in Kyustendil, when he was 21 years old and he worked as a clerk in court. In 1923, the Maystor settled in the village of Shishkovtsi, where he stayed for about 30 years, and a group of talented Bulgarian artists gathered around him – Boris Eliseev, Nikolay Dyulgerov, Kiril Tsonev, etc. A large part of his paintings were portraits and landscapes. Nature occupies a central place in the canvases of the Maystor, where he portrays it with wide strokes and hues of color close in tone.\n" +
                        "The permanent exposition of the art gallery in Kyustendil contains more than 100 masterpieces made by Vladimir Dimitrov – Maystrora. In the other halls, visitors can see exhibitions of works of art of the Kyustendil painting school and artists from the country and abroad.\n" +
                        "The gallery is often a host to various cultural events – concerts, recitals, book premiers, contests, artistic meetings, etc.\n" +
                        "Visitors of the Art Gallery “Vladimir Dimitrov – Maystora” can purchase postcards, books and catalogues containing reproductions of the most emblematic works of the artist.",
                "https://img-c.udemycdn.com/course/240x135/1693410_733a.jpg",
                date
        ));
        this.courseRepository.save(new CourseEntity(
                "Learn to Paint With Impact",
                5,
                "This course is designed to fill in the gaps left by conventional art instruction. We all want our paintings to stand out. To express our feelings or catch the eye of a collector. What is it that makes a painting move from ordinary to stunning?\n" +
                        "\n" +
                        "The secret is learning how to see like an artist. No matter what your subject the basic foundation for color, value, edges and shapes needs to be in place. I take this further with extensive video demonstrations that give you the confidence to try yourself.\n" +
                        "\n" +
                        "Challenging and fun assignments with demonstrations will help you put theory into practice. In this course you will learn by doing - the best way! Supplemented with over 200 pages of notes, video, slideshows and full demonstrations you will be able to take your painting to higher levels quickly and confidently.\n" +
                        "\n" +
                        "This course will give you the confidence and direction to paint with impact.\n" +
                        "\n" +
                        "What Others are Saying:\n" +
                        "\n" +
                        "I've been painting for many years, but never had formal study. This course is a great way to learn the foundations of painting & tools that will help drive my painting to the next level. (Lynne)\n" +
                        "\n" +
                        "Very well done. Very professional. (Bruce)\n" +
                        "\n" +
                        "Malcolm is an excellent instructor. He is welcoming and knowledgeable..I am looking forward to learning A LOT! (Joyce)\n" +
                        "\n" +
                        "Very thorough course. Unbelievable amount of information for the money I paid. Great instruction, Malcolm! (Linda)\n" +
                        "\n" +
                        "With over 202 Five Star Reviews on Udemy there is a good prospect that you will find useful and practical painting tips from my courses. My primary goal is to make a difference to YOUR painting and increase your enjoyment of painting for years to come.\n" +
                        "\n" +
                        "I hope you can join me today.\n" +
                        "\n" +
                        "Sincerely\n" +
                        "\n" +
                        "Malcolm\n" +
                        "\n" +
                        "(Course Updated October.2018)",
                "https://img-c.udemycdn.com/course/240x135/180948_c09b_9.jpg",
                date
        ));
        this.courseRepository.save(new CourseEntity(
                "The Pen and Ink Experience",
                5,
                "This course is designed to fill in the gaps left by conventional art instruction. We all want our paintings to stand out. To express our feelings or catch the eye of a collector. What is it that makes a painting move from ordinary to stunning?\n" +
                        "\n" +
                        "The secret is learning how to see like an artist. No matter what your subject the basic foundation for color, value, edges and shapes needs to be in place. I take this further with extensive video demonstrations that give you the confidence to try yourself.\n" +
                        "\n" +
                        "Challenging and fun assignments with demonstrations will help you put theory into practice. In this course you will learn by doing - the best way! Supplemented with over 200 pages of notes, video, slideshows and full demonstrations you will be able to take your painting to higher levels quickly and confidently.\n" +
                        "\n" +
                        "This course will give you the confidence and direction to paint with impact.\n" +
                        "\n" +
                        "What Others are Saying:\n" +
                        "\n" +
                        "I've been painting for many years, but never had formal study. This course is a great way to learn the foundations of painting & tools that will help drive my painting to the next level. (Lynne)\n" +
                        "\n" +
                        "Very well done. Very professional. (Bruce)\n" +
                        "\n" +
                        "Malcolm is an excellent instructor. He is welcoming and knowledgeable..I am looking forward to learning A LOT! (Joyce)\n" +
                        "\n" +
                        "Very thorough course. Unbelievable amount of information for the money I paid. Great instruction, Malcolm! (Linda)\n" +
                        "\n" +
                        "With over 202 Five Star Reviews on Udemy there is a good prospect that you will find useful and practical painting tips from my courses. My primary goal is to make a difference to YOUR painting and increase your enjoyment of painting for years to come.\n" +
                        "\n" +
                        "I hope you can join me today.\n" +
                        "\n" +
                        "Sincerely\n" +
                        "\n" +
                        "Malcolm\n" +
                        "\n" +
                        "(Course Updated October.2018)",
                "https://img-c.udemycdn.com/course/240x135/743818_c39a_2.jpg",
                date
        ));
        this.courseRepository.save(new CourseEntity(
                "The Art & Science of Drawing / BASIC SKILLS",
                4,
                "The Art & Science of Drawing is a remarkable program that will teach you how to draw one day at a time. The program is simple, each day you’ll watch one video lesson that will introduce an essential drawing skill, and then do the recommended practice. The Art & Science of Drawing is overflowing with powerful insights into the drawing process and offers some of the clearest, most accessible drawing instruction available.  Many of the tools and techniques you'll learn here are rarely seen outside of private art academies.\n" +
                        "\n" +
                        "This course is highly recommended for anyone interested in painting as well.  Most master painters agree that drawing is a fundamental and essential skill for all painters.  BASIC SKILLS is the perfect primer for anyone wanting to learn to draw. The skills you'll learn here will dramatically improve your art & design no matter what medium you work in.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "RECENTLY UPDATED & IMPROVED!\n" +
                        "\n" +
                        "This bestselling course is now even better with new content recently added as well as improved picture and sound. This updated version of the course now includes hours of bonus drawing demonstrations that will show you how to apply your new drawing skills to a wide range of subject matter including botanicals and birds.  There's even an introduction to basic figure drawing. \n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "BASIC SKILLS is the first course in a series designed to take students from the absolute basics to advanced techniques like volumetric drawing and shading. If you're a beginner, we recommend going through the entire series in the following order:\n" +
                        "Basic Skills\n" +
                        "Dynamic Mark Making\n" +
                        "Form & Space\n" +
                        "Measuring & Proportion\n" +
                        "Contours\n" +
                        "Shading Fundamentals\n" +
                        "Shading: Beyond the Basics\n" +
                        "\n" +
                        "If you've got some drawing experience, feel free to mix and match The Art & Science of Drawing courses to suit your personal needs as an artist!",
                "https://img-c.udemycdn.com/course/240x135/1045092_8c2f_2.jpg",
                date
        ));
        this.courseRepository.save(new CourseEntity(
                "The Art & Science of Figure Drawing: GESTURE",
                8,
                "In this beginning figure drawing course, you’ll learn the exciting art of gesture drawing.  Gesture drawing is one of the most important, but least understood parts of the figure drawing process, but Instructor Brent Eviston will guide you through the figure drawing process with the same award-winning instruction and hands on projects that have made his other drawing courses bestsellers.\n" +
                        "\n" +
                        "This course brings the figure drawing studio to you by providing master instruction and timed practice poses for you to draw from.  Once enrolled you’ll learn from numerous anatomical diagrams, detailed drawing demonstrations and hundreds of photographs of a fully nude model.\n" +
                        "\n" +
                        "This course contains 12 lessons, each filled with essential figure drawing techniques. Each lesson contains at least one practice reel with timed poses specifically chosen so you can get the most out of the lesson they accompany.\n" +
                        "\n" +
                        "By the end of this course you’ll be able to do gesture drawings that stand alone as works of art as well as lay the foundation for more detailed figure drawings.\n" +
                        "\n" +
                        "Because this course features photographs of a fully nude model, it is important that you conduct yourself maturely and appropriately in the course.\n" +
                        "\n" +
                        "Although this is a beginning figure drawing course, it is not a beginning drawing course.  Some basic drawing skills are recommended.",
                "https://img-c.udemycdn.com/course/240x135/1693410_733a.jpg",
                date
        ));
        this.courseRepository.save(new CourseEntity(
                "Learn to Paint With Impact",
                5,
                "This course is designed to fill in the gaps left by conventional art instruction. We all want our paintings to stand out. To express our feelings or catch the eye of a collector. What is it that makes a painting move from ordinary to stunning?\n" +
                        "\n" +
                        "The secret is learning how to see like an artist. No matter what your subject the basic foundation for color, value, edges and shapes needs to be in place. I take this further with extensive video demonstrations that give you the confidence to try yourself.\n" +
                        "\n" +
                        "Challenging and fun assignments with demonstrations will help you put theory into practice. In this course you will learn by doing - the best way! Supplemented with over 200 pages of notes, video, slideshows and full demonstrations you will be able to take your painting to higher levels quickly and confidently.\n" +
                        "\n" +
                        "This course will give you the confidence and direction to paint with impact.\n" +
                        "\n" +
                        "What Others are Saying:\n" +
                        "\n" +
                        "I've been painting for many years, but never had formal study. This course is a great way to learn the foundations of painting & tools that will help drive my painting to the next level. (Lynne)\n" +
                        "\n" +
                        "Very well done. Very professional. (Bruce)\n" +
                        "\n" +
                        "Malcolm is an excellent instructor. He is welcoming and knowledgeable..I am looking forward to learning A LOT! (Joyce)\n" +
                        "\n" +
                        "Very thorough course. Unbelievable amount of information for the money I paid. Great instruction, Malcolm! (Linda)\n" +
                        "\n" +
                        "With over 202 Five Star Reviews on Udemy there is a good prospect that you will find useful and practical painting tips from my courses. My primary goal is to make a difference to YOUR painting and increase your enjoyment of painting for years to come.\n" +
                        "\n" +
                        "I hope you can join me today.\n" +
                        "\n" +
                        "Sincerely\n" +
                        "\n" +
                        "Malcolm\n" +
                        "\n" +
                        "(Course Updated October.2018)",
                "https://img-c.udemycdn.com/course/240x135/180948_c09b_9.jpg",
                date
        ));
        this.courseRepository.save(new CourseEntity(
                "The Pen and Ink Experience",
                5,
                "This course is designed to fill in the gaps left by conventional art instruction. We all want our paintings to stand out. To express our feelings or catch the eye of a collector. What is it that makes a painting move from ordinary to stunning?\n" +
                        "\n" +
                        "The secret is learning how to see like an artist. No matter what your subject the basic foundation for color, value, edges and shapes needs to be in place. I take this further with extensive video demonstrations that give you the confidence to try yourself.\n" +
                        "\n" +
                        "Challenging and fun assignments with demonstrations will help you put theory into practice. In this course you will learn by doing - the best way! Supplemented with over 200 pages of notes, video, slideshows and full demonstrations you will be able to take your painting to higher levels quickly and confidently.\n" +
                        "\n" +
                        "This course will give you the confidence and direction to paint with impact.\n" +
                        "\n" +
                        "What Others are Saying:\n" +
                        "\n" +
                        "I've been painting for many years, but never had formal study. This course is a great way to learn the foundations of painting & tools that will help drive my painting to the next level. (Lynne)\n" +
                        "\n" +
                        "Very well done. Very professional. (Bruce)\n" +
                        "\n" +
                        "Malcolm is an excellent instructor. He is welcoming and knowledgeable..I am looking forward to learning A LOT! (Joyce)\n" +
                        "\n" +
                        "Very thorough course. Unbelievable amount of information for the money I paid. Great instruction, Malcolm! (Linda)\n" +
                        "\n" +
                        "With over 202 Five Star Reviews on Udemy there is a good prospect that you will find useful and practical painting tips from my courses. My primary goal is to make a difference to YOUR painting and increase your enjoyment of painting for years to come.\n" +
                        "\n" +
                        "I hope you can join me today.\n" +
                        "\n" +
                        "Sincerely\n" +
                        "\n" +
                        "Malcolm\n" +
                        "\n" +
                        "(Course Updated October.2018)",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRjsFxIVYi_xr85Y-934DUSQuJ7ZJZIxJfZ1uyJDHHiC-DxfgyZqo0-ESUoxF9a_ZcPZVs&usqp=CAU",
                date
        ));

        this.courseRepository.save(new CourseEntity(
                "\n" +
                        "Art Gallery “Vladimir Dimitrov – Maystora” – town of Kyustendil",
                4,
                "The Art Gallery “Vladimir Dimitrov – Maystora” in Kyustendil was established in 1972 in honor of the 90th anniversary of the renowned artist. The building occupies an area of 4,200 square meters and has seven exposition halls with natural upper lighting.\n" +
                        "Vladimir Dimitrov – Maystora (The Master) (1882 – 1960) is one of the most renowned Bulgarian artists. Its specific style can not be mistaken – his paintings are exceptionally impressive with their vivid colors and unique painting style.\n" +
                        "The artist was born in the Kyustendil village of Frolosh in 1882. He studies in Kyustendil and passed through a number of professions until the local people noticed his incredible talent and helped him go and study in the Arts School (which is presently an academy) in Sofia. His first exhibition was opened on 21 May 1903 in the halls of the Regional Court in Kyustendil, when he was 21 years old and he worked as a clerk in court. In 1923, the Maystor settled in the village of Shishkovtsi, where he stayed for about 30 years, and a group of talented Bulgarian artists gathered around him – Boris Eliseev, Nikolay Dyulgerov, Kiril Tsonev, etc. A large part of his paintings were portraits and landscapes. Nature occupies a central place in the canvases of the Maystor, where he portrays it with wide strokes and hues of color close in tone.\n" +
                        "The permanent exposition of the art gallery in Kyustendil contains more than 100 masterpieces made by Vladimir Dimitrov – Maystrora. In the other halls, visitors can see exhibitions of works of art of the Kyustendil painting school and artists from the country and abroad.\n" +
                        "The gallery is often a host to various cultural events – concerts, recitals, book premiers, contests, artistic meetings, etc.\n" +
                        "Visitors of the Art Gallery “Vladimir Dimitrov – Maystora” can purchase postcards, books and catalogues containing reproductions of the most emblematic works of the artist.",
                "http://www.auction-rakursi.com/img_m14/011.jpg",
                date
        ));
        this.courseRepository.save(new CourseEntity(
                "The Art & Science of Figure Drawing: GESTURE",
                8,
                "The Art Gallery “Vladimir Dimitrov – Maystora” in Kyustendil was established in 1972 in honor of the 90th anniversary of the renowned artist. The building occupies an area of 4,200 square meters and has seven exposition halls with natural upper lighting.\n" +
                        "Vladimir Dimitrov – Maystora (The Master) (1882 – 1960) is one of the most renowned Bulgarian artists. Its specific style can not be mistaken – his paintings are exceptionally impressive with their vivid colors and unique painting style.\n" +
                        "The artist was born in the Kyustendil village of Frolosh in 1882. He studies in Kyustendil and passed through a number of professions until the local people noticed his incredible talent and helped him go and study in the Arts School (which is presently an academy) in Sofia. His first exhibition was opened on 21 May 1903 in the halls of the Regional Court in Kyustendil, when he was 21 years old and he worked as a clerk in court. In 1923, the Maystor settled in the village of Shishkovtsi, where he stayed for about 30 years, and a group of talented Bulgarian artists gathered around him – Boris Eliseev, Nikolay Dyulgerov, Kiril Tsonev, etc. A large part of his paintings were portraits and landscapes. Nature occupies a central place in the canvases of the Maystor, where he portrays it with wide strokes and hues of color close in tone.\n" +
                        "The permanent exposition of the art gallery in Kyustendil contains more than 100 masterpieces made by Vladimir Dimitrov – Maystrora. In the other halls, visitors can see exhibitions of works of art of the Kyustendil painting school and artists from the country and abroad.\n" +
                        "The gallery is often a host to various cultural events – concerts, recitals, book premiers, contests, artistic meetings, etc.\n" +
                        "Visitors of the Art Gallery “Vladimir Dimitrov – Maystora” can purchase postcards, books and catalogues containing reproductions of the most emblematic works of the artist.",
                "https://img-c.udemycdn.com/course/240x135/1693410_733a.jpg",
                date
        ));
        this.courseRepository.save(new CourseEntity(
                "Learn to Paint With Impact",
                5,
                "This course is designed to fill in the gaps left by conventional art instruction. We all want our paintings to stand out. To express our feelings or catch the eye of a collector. What is it that makes a painting move from ordinary to stunning?\n" +
                        "\n" +
                        "The secret is learning how to see like an artist. No matter what your subject the basic foundation for color, value, edges and shapes needs to be in place. I take this further with extensive video demonstrations that give you the confidence to try yourself.\n" +
                        "\n" +
                        "Challenging and fun assignments with demonstrations will help you put theory into practice. In this course you will learn by doing - the best way! Supplemented with over 200 pages of notes, video, slideshows and full demonstrations you will be able to take your painting to higher levels quickly and confidently.\n" +
                        "\n" +
                        "This course will give you the confidence and direction to paint with impact.\n" +
                        "\n" +
                        "What Others are Saying:\n" +
                        "\n" +
                        "I've been painting for many years, but never had formal study. This course is a great way to learn the foundations of painting & tools that will help drive my painting to the next level. (Lynne)\n" +
                        "\n" +
                        "Very well done. Very professional. (Bruce)\n" +
                        "\n" +
                        "Malcolm is an excellent instructor. He is welcoming and knowledgeable..I am looking forward to learning A LOT! (Joyce)\n" +
                        "\n" +
                        "Very thorough course. Unbelievable amount of information for the money I paid. Great instruction, Malcolm! (Linda)\n" +
                        "\n" +
                        "With over 202 Five Star Reviews on Udemy there is a good prospect that you will find useful and practical painting tips from my courses. My primary goal is to make a difference to YOUR painting and increase your enjoyment of painting for years to come.\n" +
                        "\n" +
                        "I hope you can join me today.\n" +
                        "\n" +
                        "Sincerely\n" +
                        "\n" +
                        "Malcolm\n" +
                        "\n" +
                        "(Course Updated October.2018)",
                "https://img-c.udemycdn.com/course/240x135/180948_c09b_9.jpg",
                date
        ));
        this.courseRepository.save(new CourseEntity(
                "The Pen and Ink Experience",
                5,
                "This course is designed to fill in the gaps left by conventional art instruction. We all want our paintings to stand out. To express our feelings or catch the eye of a collector. What is it that makes a painting move from ordinary to stunning?\n" +
                        "\n" +
                        "The secret is learning how to see like an artist. No matter what your subject the basic foundation for color, value, edges and shapes needs to be in place. I take this further with extensive video demonstrations that give you the confidence to try yourself.\n" +
                        "\n" +
                        "Challenging and fun assignments with demonstrations will help you put theory into practice. In this course you will learn by doing - the best way! Supplemented with over 200 pages of notes, video, slideshows and full demonstrations you will be able to take your painting to higher levels quickly and confidently.\n" +
                        "\n" +
                        "This course will give you the confidence and direction to paint with impact.\n" +
                        "\n" +
                        "What Others are Saying:\n" +
                        "\n" +
                        "I've been painting for many years, but never had formal study. This course is a great way to learn the foundations of painting & tools that will help drive my painting to the next level. (Lynne)\n" +
                        "\n" +
                        "Very well done. Very professional. (Bruce)\n" +
                        "\n" +
                        "Malcolm is an excellent instructor. He is welcoming and knowledgeable..I am looking forward to learning A LOT! (Joyce)\n" +
                        "\n" +
                        "Very thorough course. Unbelievable amount of information for the money I paid. Great instruction, Malcolm! (Linda)\n" +
                        "\n" +
                        "With over 202 Five Star Reviews on Udemy there is a good prospect that you will find useful and practical painting tips from my courses. My primary goal is to make a difference to YOUR painting and increase your enjoyment of painting for years to come.\n" +
                        "\n" +
                        "I hope you can join me today.\n" +
                        "\n" +
                        "Sincerely\n" +
                        "\n" +
                        "Malcolm\n" +
                        "\n" +
                        "(Course Updated October.2018)",
                "https://img-c.udemycdn.com/course/240x135/743818_c39a_2.jpg",
                date
        ));
        this.courseRepository.save(new CourseEntity(
                "The Art & Science of Drawing / BASIC SKILLS",
                4,
                "The Art & Science of Drawing is a remarkable program that will teach you how to draw one day at a time. The program is simple, each day you’ll watch one video lesson that will introduce an essential drawing skill, and then do the recommended practice. The Art & Science of Drawing is overflowing with powerful insights into the drawing process and offers some of the clearest, most accessible drawing instruction available.  Many of the tools and techniques you'll learn here are rarely seen outside of private art academies.\n" +
                        "\n" +
                        "This course is highly recommended for anyone interested in painting as well.  Most master painters agree that drawing is a fundamental and essential skill for all painters.  BASIC SKILLS is the perfect primer for anyone wanting to learn to draw. The skills you'll learn here will dramatically improve your art & design no matter what medium you work in.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "RECENTLY UPDATED & IMPROVED!\n" +
                        "\n" +
                        "This bestselling course is now even better with new content recently added as well as improved picture and sound. This updated version of the course now includes hours of bonus drawing demonstrations that will show you how to apply your new drawing skills to a wide range of subject matter including botanicals and birds.  There's even an introduction to basic figure drawing. \n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "BASIC SKILLS is the first course in a series designed to take students from the absolute basics to advanced techniques like volumetric drawing and shading. If you're a beginner, we recommend going through the entire series in the following order:\n" +
                        "Basic Skills\n" +
                        "Dynamic Mark Making\n" +
                        "Form & Space\n" +
                        "Measuring & Proportion\n" +
                        "Contours\n" +
                        "Shading Fundamentals\n" +
                        "Shading: Beyond the Basics\n" +
                        "\n" +
                        "If you've got some drawing experience, feel free to mix and match The Art & Science of Drawing courses to suit your personal needs as an artist!",
                "https://img-c.udemycdn.com/course/240x135/1045092_8c2f_2.jpg",
                date
        ));
        this.courseRepository.save(new CourseEntity(
                "The Art & Science of Figure Drawing: GESTURE",
                8,
                "In this beginning figure drawing course, you’ll learn the exciting art of gesture drawing.  Gesture drawing is one of the most important, but least understood parts of the figure drawing process, but Instructor Brent Eviston will guide you through the figure drawing process with the same award-winning instruction and hands on projects that have made his other drawing courses bestsellers.\n" +
                        "\n" +
                        "This course brings the figure drawing studio to you by providing master instruction and timed practice poses for you to draw from.  Once enrolled you’ll learn from numerous anatomical diagrams, detailed drawing demonstrations and hundreds of photographs of a fully nude model.\n" +
                        "\n" +
                        "This course contains 12 lessons, each filled with essential figure drawing techniques. Each lesson contains at least one practice reel with timed poses specifically chosen so you can get the most out of the lesson they accompany.\n" +
                        "\n" +
                        "By the end of this course you’ll be able to do gesture drawings that stand alone as works of art as well as lay the foundation for more detailed figure drawings.\n" +
                        "\n" +
                        "Because this course features photographs of a fully nude model, it is important that you conduct yourself maturely and appropriately in the course.\n" +
                        "\n" +
                        "Although this is a beginning figure drawing course, it is not a beginning drawing course.  Some basic drawing skills are recommended.",
                "https://img-c.udemycdn.com/course/240x135/1693410_733a.jpg",
                date
        ));
        this.courseRepository.save(new CourseEntity(
                "Learn to Paint With Impact",
                5,
                "This course is designed to fill in the gaps left by conventional art instruction. We all want our paintings to stand out. To express our feelings or catch the eye of a collector. What is it that makes a painting move from ordinary to stunning?\n" +
                        "\n" +
                        "The secret is learning how to see like an artist. No matter what your subject the basic foundation for color, value, edges and shapes needs to be in place. I take this further with extensive video demonstrations that give you the confidence to try yourself.\n" +
                        "\n" +
                        "Challenging and fun assignments with demonstrations will help you put theory into practice. In this course you will learn by doing - the best way! Supplemented with over 200 pages of notes, video, slideshows and full demonstrations you will be able to take your painting to higher levels quickly and confidently.\n" +
                        "\n" +
                        "This course will give you the confidence and direction to paint with impact.\n" +
                        "\n" +
                        "What Others are Saying:\n" +
                        "\n" +
                        "I've been painting for many years, but never had formal study. This course is a great way to learn the foundations of painting & tools that will help drive my painting to the next level. (Lynne)\n" +
                        "\n" +
                        "Very well done. Very professional. (Bruce)\n" +
                        "\n" +
                        "Malcolm is an excellent instructor. He is welcoming and knowledgeable..I am looking forward to learning A LOT! (Joyce)\n" +
                        "\n" +
                        "Very thorough course. Unbelievable amount of information for the money I paid. Great instruction, Malcolm! (Linda)\n" +
                        "\n" +
                        "With over 202 Five Star Reviews on Udemy there is a good prospect that you will find useful and practical painting tips from my courses. My primary goal is to make a difference to YOUR painting and increase your enjoyment of painting for years to come.\n" +
                        "\n" +
                        "I hope you can join me today.\n" +
                        "\n" +
                        "Sincerely\n" +
                        "\n" +
                        "Malcolm\n" +
                        "\n" +
                        "(Course Updated October.2018)",
                "https://img-c.udemycdn.com/course/240x135/180948_c09b_9.jpg",
                date
        ));
        this.courseRepository.save(new CourseEntity(
                "The Pen and Ink Experience",
                5,
                "This course is designed to fill in the gaps left by conventional art instruction. We all want our paintings to stand out. To express our feelings or catch the eye of a collector. What is it that makes a painting move from ordinary to stunning?\n" +
                        "\n" +
                        "The secret is learning how to see like an artist. No matter what your subject the basic foundation for color, value, edges and shapes needs to be in place. I take this further with extensive video demonstrations that give you the confidence to try yourself.\n" +
                        "\n" +
                        "Challenging and fun assignments with demonstrations will help you put theory into practice. In this course you will learn by doing - the best way! Supplemented with over 200 pages of notes, video, slideshows and full demonstrations you will be able to take your painting to higher levels quickly and confidently.\n" +
                        "\n" +
                        "This course will give you the confidence and direction to paint with impact.\n" +
                        "\n" +
                        "What Others are Saying:\n" +
                        "\n" +
                        "I've been painting for many years, but never had formal study. This course is a great way to learn the foundations of painting & tools that will help drive my painting to the next level. (Lynne)\n" +
                        "\n" +
                        "Very well done. Very professional. (Bruce)\n" +
                        "\n" +
                        "Malcolm is an excellent instructor. He is welcoming and knowledgeable..I am looking forward to learning A LOT! (Joyce)\n" +
                        "\n" +
                        "Very thorough course. Unbelievable amount of information for the money I paid. Great instruction, Malcolm! (Linda)\n" +
                        "\n" +
                        "With over 202 Five Star Reviews on Udemy there is a good prospect that you will find useful and practical painting tips from my courses. My primary goal is to make a difference to YOUR painting and increase your enjoyment of painting for years to come.\n" +
                        "\n" +
                        "I hope you can join me today.\n" +
                        "\n" +
                        "Sincerely\n" +
                        "\n" +
                        "Malcolm\n" +
                        "\n" +
                        "(Course Updated October.2018)",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRjsFxIVYi_xr85Y-934DUSQuJ7ZJZIxJfZ1uyJDHHiC-DxfgyZqo0-ESUoxF9a_ZcPZVs&usqp=CAU",
                date
        ));
    }

}
