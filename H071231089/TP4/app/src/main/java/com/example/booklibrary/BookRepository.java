package com.example.booklibrary;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static BookRepository instance;
    private List<Book> books;

    private BookRepository() {
        books = new ArrayList<>();
        addDummyBooks();
    }

    public static synchronized BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    private void addDummyBooks() {
        books.add(new Book("Mushoku Tensei - Jobless Reincarnation 2", "Rifujin Na Magonote", "Ujian terus menghadang Rudeus, mantan NEET berusia 34 tahun yang terlahir kembali di dunia tempat ksatria dan penyihir, demi menunaikan tekad hidupnya dengan serius… Yang menghadangnya kali ini adalah seorang putri bangsawan yang penuh kekerasan. Tapi meski takut akan kekerasan dari sang tuan putri, Rudeus tetap menjalani perannya sebagai guru privat demi menjalankan ‘suatu rencana’ dengan serius!\n", 2024, "Fantasi", "https://image.gramedia.net/rs:fit:0:0/plain/https://cdn.gramedia.com/uploads/products/066eoo2us3.png", 4.5));
        books.add(new Book("Light Novel The Eminence in Shadow 1", "Daisuke Aizawa", "Kisah seorang pemuda yang terlahir kembali di dunia lain dan berusaha untuk menjadi 'bayangan' yang mengendalikan segalanya dari belakang. Ia membentuk organisasi rahasia untuk melawan kekuatan jahat yang mengancam dunia.\n", 2024, "Fantasi", "https://image.gramedia.net/rs:fit:0:0/plain/https://cdn.gramedia.com/uploads/products/z-eceagc-1.png", 4.3));
        books.add(new Book("Konosuba: God's Blessing on This Wonderful World! 1",
                "Kurone Mishima",
                "Kehidupan Kazuma Sato, seorang anak laki-laki penyendiri yang menyukai game, seharusnya telah berakhir. Namun ketika dia terbangun, seorang “dewi” yang cantik nan menyebalkan menawarkan padanya untuk hidup kembali di dunia lain. “Kamu akan terbangun di dunia lain, tapi sebelumnya kamu boleh meminta satu hal apa pun untuk di bawa ke sana. Aku akan mengabulkannya.”\n",
                2024,
                "Fantasi",
                "https://image.gramedia.net/rs:fit:0:0/plain/https://cdn.gramedia.com/uploads/picture_meta/2024/6/11/tkvhpvrwalyi9ujkofwvw9.png",
                4.7));
        books.add(new Book("Re:Zero : Starting Life in Another World 01",
                "Tappei Nagatsuki",
                "Seorang gadis cantik berambut perak dan roh kucingnya, datang menyelamatkan Subaru. Untuk membalas budi, Subaru memutuskan membantu menemukan sesuatu milik gadis itu yang hilang. Namun, saat mereka hampir menemukan petunjuk, Subaru dan gadis itu diserang oleh seseorang dan kehilangan nyawa mereka—ketika sadar, Subaru mendapati dirinya kembali ke tempat ia pertama kali dipanggil ke dunia lain.\n",
                2024,
                "Fantasi",
                "https://image.gramedia.net/rs:fit:0:0/plain/https://cdn.gramedia.com/uploads/products/5ozh23e8zn.png",
                4.8));
        books.add(new Book("The Eminence in Shadow 2",
                "Daisuke Aizawa",
                "Cid bereinkarnasi ke dunia lain. Seperti biasa, ia menikmati latar cerita “Mastermind di Balik Bayangan” yang melakukan intervensi terhadap segala hal serta menunjukkan kekuatannya dari balik layar. Demi menyelamatkan tuan putri sekaligus kawannya yang menyebalkan dari penculikan, Cid menjadi Shadow dan berangkat menuju markas Kultus Diabolos!\n",
                2024,
                "Fantasi",
                "https://image.gramedia.net/rs:fit:0:0/plain/https://cdn.gramedia.com/uploads/products/wd22c2x-e3.png",
                4.7));
        books.add(new Book("Martin Si Anak Magang",
                "Vernando Altamirano",
                "Halooo para Lapet!! Selamat datang di komik \"Martín sí Anak Magang\"! Komik dí mana sí Martin selalu buat salah dan gak pernah betul lah tingkahnya di kantor kutengok. Sampai-sampai bosnya si Bang Mikhail naik darah dibuatnya. Kalian penasaran? Mau naik darah sambil ketawa kan Lapet? Ayolah baca komik ini Lapet! Komik ini juga berisi cerita-cerita eksklusif yang belum pernah dipublikasikan di mana pun oleh Vernalta",
                2024,
                "Humor",
                "https://image.gramedia.net/rs:fit:0:0/plain/https://cdn.gramedia.com/uploads/picture_meta/2024/3/21/kh7zwq4mlbazp9bsnwzamg.jpg",
                4.3));
        books.add(new Book("Seporsi Mie Ayam Sebelum Mati",
                "Brian Khrisna",
                "Ale, seorang pria berusia 37 tahun memiliki tinggi badan 189 cm dan berat 138 kg. Badannya bongsor, berkulit hitam, dan memiliki masalah dengan bau badan. Sejak kecil, Ale hidup di lingkungan keluarga yang tidak mendukungnya. Ia tak memiliki teman dekat dan menjadi korban perundungan di sekolahnya",
                2024,
                "Kehidupan Kota",
                "https://image.gramedia.net/rs:fit:0:0/plain/https://cdn.gramedia.com/uploads/products/95ob5m98ur.jpg",
                4.1));
        books.add(new Book("Ayah Berjuang Sendiri Itu Capek!",
                "Adellia P. D.",
                "Menjalani kehidupan sebagai mahasiswi akhir kedokteran dengan beasiswa saja, sudah membuat Brichia sering memijat kepala. Cobaan demi cobaan silih berganti menghampiri hidupnya.\n" +
                        "\n" +
                        "Dunia Brichia yang sudah rapuh, kini benar-benar runtuh setelah ayahnya jatuh sakit. la rela berjualan ayam potong menggantikan ayahnya yang sakit parah. Belum lagi hubungan dengan kakaknya, Nafaesa, yang kurang baik.\n",
                2024,
                "Kehidupan Kota",
                "https://image.gramedia.net/rs:fit:0:0/plain/https://cdn.gramedia.com/uploads/product-metas/snab-g1-y2.jpg",
                4.1));
        books.add(new Book("Blue Period Vol. 02",
                "Tsubasa Yamaguchi",
                "Yaguchi Yatora adalah seorang siswa SMA yang menemukan keasyikan melukis, hingga ia memutuskan untuk masuk ke universitas seni. Pemuda gaul dan popular yang selama ini fokus pada kehidupan sosial serta belajar sekadar untuk memenuhi kuota itu, pertama kalinya merasakan semangat membara terhadap sesuatu. Hal itu pun mengubah hidupnya. Inilah cerita tentang ujian masuk sekolah seni yang akan menggugah bahkan orang yang tidak menggambar. Dunia ini penuh cobaan dan kegembiraan!",
                2024,
                "Manga",
                "https://image.gramedia.net/rs:fit:0:0/plain/https://cdn.gramedia.com/uploads/product-metas/zx02-34ude.png",
                4.1));

        books.add(new Book("Classroom of the Elite Vol 2", "Yuyu Ichino", "‘Sekolah Koudo Ikusei’ adalah sekolah paling ternama di seluruh negeri. Siswanya",2024 , "Fantasi", "https://image.gramedia.net/rs:fit:0:0/plain/https://cdn.gramedia.com/uploads/products/ocvfooo4zt.png",  4.5));
    }

    public List<Book> getBooks() {
        return books;
    }

    public void updateFavoriteStatus(String title, boolean isFavorite) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.setFavorite(isFavorite);
                break;
            }
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }
}