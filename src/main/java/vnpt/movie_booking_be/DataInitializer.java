package vnpt.movie_booking_be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import vnpt.movie_booking_be.models.*;
import vnpt.movie_booking_be.repository.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MembershipRepository membershipRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<Movie> movies = movieRepository.findAll();
//        System.out.println(movies.get(1));
//        for(Movie movie : movies) {
//            System.out.println(movie.getGenres());
//        }

        if(roleRepository.findByName("ADMIN") != null){
                return;
        }
        Membership membership = membershipRepository.save(Membership.builder()
                .name("Đồng")
                .description("Đồng")
                .discount_rate(0.0f)
                .build());
        membershipRepository.save(Membership.builder()
                .name("Bạc")
                .description("Bạc")
                .discount_rate(0.05f)
                .build());
        membershipRepository.save(Membership.builder()
                .name("Vàng")
                .description("vàng")
                .discount_rate(0.1f)
                .build());


        Role adminRole = roleRepository.save(Role.builder().name("ADMIN").build());
        roleRepository.save(Role.builder().name("USER").build());

        userRepository.save(User.builder()
                .name("admin")
                .email("admin@gmail.com")
                .phone("0943946242")
                .password(passwordEncoder.encode("admin"))
                .roles(Collections.singleton(adminRole))
                .build());


        Genre actionGenre = genreRepository.save(Genre.builder().name("Hành động").build());
        Genre adventureGenre = genreRepository.save(Genre.builder().name("Phiêu lưu").build());
        genreRepository.save(Genre.builder().name("Hoạt hình").build());
        genreRepository.save(Genre.builder().name("Bí ẩn").build());
        genreRepository.save(Genre.builder().name("Hài hước").build());
        genreRepository.save(Genre.builder().name("Tội phạm").build());
        genreRepository.save(Genre.builder().name("Gia đình").build());
        genreRepository.save(Genre.builder().name("Fantasia").build());
        genreRepository.save(Genre.builder().name("Kinh dị").build());
        genreRepository.save(Genre.builder().name("Lãng mạn").build());
        genreRepository.save(Genre.builder().name("Khoa học viễn tưởng").build());
        genreRepository.save(Genre.builder().name("Thần thoại").build());
        genreRepository.save(Genre.builder().name("Thể thao").build());
        genreRepository.save(Genre.builder().name("Chiến tranh").build());
        genreRepository.save(Genre.builder().name("Xã hội").build());
        genreRepository.save(Genre.builder().name("Tâm lý").build());
        genreRepository.save(Genre.builder().name("Trinh thám").build());
        genreRepository.save(Genre.builder().name("Thám hiểm").build());
        genreRepository.save(Genre.builder().name("Võ thuật").build());

        Set<String> casts = new HashSet<>();
        casts.add("Sandra Bullock");
        casts.add("Channing Tatum");
        casts.add("Daniel Radcliffe");

            Set<Genre> genreSet = new HashSet<>();
            genreSet.add(actionGenre);
            genreSet.add(adventureGenre);

            movieRepository.save(Movie.builder()
                    .title("The Lost City ")
                    .description("Bộ phim hành động hay The Lost City gây ấn tượng với khán giả nhờ vào khung cảnh thiên nhiên" +
                            " hùng vĩ và những màn hành động đầy ấn tượng. Câu chuyện xoay quanh vị" +
                            " tác giả tài năng Loretta Sage, người đã dành cả cuộc đời của mình để khám" +
                            " phá những địa điểm kỳ lạ và viết sách. Trong chuyến quảng bá sách của mình," +
                            " cô bị một tỷ phú kỳ quái bắt cóc và ép buộc chỉ đường đến một thành phố bí ẩn," +
                            " nơi ẩn chứa một kho báu.")
                    .director("Aaron và Adam Nee")
                    .casts(casts)
                    .duration(112)
                    .genres(genreSet)
                    .build());

    }
}
