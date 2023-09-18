
/** 유저 | User */

@Entity
@Table(name = "User")
@Getter
@@EqualsAndHashCode
@NoArgsConstructor
@Builder
public class User {

    // 유저_ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id" ,nullable = false)
    private Integer userId;

// 아이디
    @Column(name = "username" ,nullable = false ,length = n)
    private String username;

// 비밀번호
    @Column(name = "password" ,nullable = false ,length = n)
    private String password;

// 닉네임
    @Column(name = "nickname" ,nullable = false ,length = n)
    private String nickname;

// 생일
    @Column(name = "birth" ,nullable = false)
    private LocalDateTime birth;

// 이메일
    @Column(name = "email" ,length = n)
    private String email;

// 가입일자
    @Column(name = "created_at" ,nullable = false)
    private LocalDateTime createdAt;

// 회원정보수정일자
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

// 탈퇴여부
    @Column(name = "is_deleted" ,nullable = false)
    private Boolean isDeleted;

}


/** 메인페이지 | main_post */

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MainPostId implements Serializable {

    // 포스트아이디
    private Integer postId;

// 유저_ID
    private Integer userId;

}

@Entity
@Table(name = "main_post")
@Getter
@@EqualsAndHashCode
@NoArgsConstructor
@Builder
@IdClass(MainPostId.class)
public class MainPost {

    // 포스트아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id" ,nullable = false)
    private Integer postId;

// 메인사진
    @Column(name = "main_picture")
    private String mainPicture;

// 메인페이지_소개글
    @Column(name = "post_intro" ,length = n)
    private String postIntro;

// 유저_ID
    @Id
    @Column(name = "user_id" ,nullable = false)
    private Integer userId;

    @OneToOne
@JoinColumn(name = "user_id")
    private User user;

}


/** 프로필 | profile */

@Entity
@Table(name = "profile")
@Getter
@@EqualsAndHashCode
@NoArgsConstructor
@Builder
public class Profile {

    // 20문답_번호
    @Column(name = "questions_id" ,nullable = false)
    private Integer questionsId;

// 유저_닉네임
    @Column(name = "user_nickname" ,length = n)
    private String userNickname;

// 유저_생일
    @Column(name = "user_birthday")
    private LocalDateTime userBirthday;

// 유저_이메일
    @Column(name = "user_email" ,length = n)
    private String userEmail;

// 좌우명
    @Column(name = "motto")
    private String motto;

// 유저_ID
    @Id
    @Column(name = "user_id" ,nullable = false)
    private Integer userId;

    @OneToOne
@JoinColumn(name = "user_id")
    private User user;

}


/** 20문답 | questions_20 */

@Entity
@Table(name = "questions_20")
@Getter
@@EqualsAndHashCode
@NoArgsConstructor
@Builder
public class Questions20 {

    // 20문답_아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questions_id" ,nullable = false)
    private Integer questionsId;

// 당신의 mbti는?
    @Column(name = "mbti" ,length = 4)
    private String mbti;

    @OneToOne
@JoinColumn(name = "user_id")
    private Profile profile;

}


/** 다이어리 | diary */

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DiaryId implements Serializable {

    // 다이어리_ID
    private Integer id;

// 유저_ID
    private Integer userId;

}

@Entity
@Table(name = "diary")
@Getter
@@EqualsAndHashCode
@NoArgsConstructor
@Builder
@IdClass(DiaryId.class)
public class Diary {

    // 다이어리_ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,nullable = false)
    private Integer id;

// 오늘_날짜
    @Column(name = "today_date")
    private LocalDateTime todayDate;

// 오늘의_기분
    @Column(name = "today_feel" ,length = 2)
    private String todayFeel;

// 제목
    @Column(name = "title" ,length = n)
    private String title;

// 본문
    @Column(name = "content")
    private String content;

// 사진
    @Column(name = "picture")
    private String picture;

// 좋아요
    @Column(name = "like")
    private Integer like;

// 유저_ID
    @Id
    @Column(name = "user_id" ,nullable = false)
    private Integer userId;

// 공개여부
    @Column(name = "is_private")
    private Boolean isPrivate;

    @ManyToOne
@JoinColumn(name = "user_id")
    private User user;

    @OneToOne
@JoinColumn(name = "sticker_id")
    private Sticker sticker;

}



/** 스티커 | sticker */

@Entity
@Table(name = "sticker")
@Getter
@@EqualsAndHashCode
@NoArgsConstructor
@Builder
public class Sticker {

    // 스티커번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sticker_id" ,nullable = false)
    private Integer stickerId;

// 이름
    @Column(name = "name" ,nullable = false ,length = n)
    private String name;

// 설명
    @Column(name = "explain" ,length = n)
    private String explain;

}

