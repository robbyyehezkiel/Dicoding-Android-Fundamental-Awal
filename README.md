# Dicoding-Android-Fundamental-Awal
Dicoding Android Fundamental Awal adalah aplikasi yang harus disubmit dalam menyelesaikan kelas [Belajar Fundamental Aplikasi Android](https://www.dicoding.com/academies/14/)
Kelas ditujukan bagi developer yang ingin belajar fundamental pembuatan aplikasi Android, seperti networking dan database, dengan mengacu pada standar kompetensi internasional milik Google Developers Authorized Training Partner. 

## SCREENSHOT!
<img src="https://github.com/robbyyehezkiel/Dicoding-Android-Fundamental-Awal/assets/107051384/4b2942ad-3a00-4444-87f5-d766e0c8443e" alt="Screenshot_20231228_234319" width="250">   
<img src="https://github.com/robbyyehezkiel/Dicoding-Android-Fundamental-Awal/assets/107051384/5d52517f-7e2b-4c82-a386-2b634c0caf75" alt="Screenshot_20231228_234336" width="250">   

## Petunjuk Instalasi
1. Kloning Repositori::
   - Buka terminal atau command prompt di komputer lokal Anda.
   - Gunakan perintah **git clone** diikuti dengan URL yang telah Anda salin.
     ```
     git clone https://github.com/robbyyehezkiel/Dicoding-Android-Fundamental-Awal.git
     ```
3. Buka Proyek di Android Studio:<br>
   Buka Android Studio dan buka proyek yang telah Anda kloning.
4. Bangun Proyek:<br>
   Setelah proyek dimuat, bangun proyek menggunakan opsi **build** di Android Studio.
5. Hubungkan Perangkat Anda:<br>
   Hubungkan perangkat Android Anda ke komputer menggunakan kabel USB dan pastikan debugging USB diaktifkan pada perangkat Anda.
7. Jalankan Aplikasi:
   - Pilih perangkat yang terhubung dari daftar perangkat yang tersedia di Android Studio.
   - Klik tombol **Run** untuk menginstal dan meluncurkan aplikasi di perangkat Anda.
8. Atau, Gunakan Emulator:<br>
   Jika Anda tidak memiliki perangkat fisik, Anda dapat menggunakan Emulator Android yang disediakan oleh Android Studio. Cukup buat perangkat virtual menggunakan AVD Manager dan jalankan aplikasi di emulator.

## KRITERIA SUBMISSION AKHIR APLIKASI

1. **Search User**<br>
   Syarat:
   - Menampilkan list data user dari API menggunakan RecyclerView dengan data minimal foto avatar dan username.
   - Pencarian user menggunakan data dari API berjalan dengan baik.
   - Pengguna dapat melihat halaman detail dari hasil daftar pencarian.
    
2. **Halaman Detail**<br>
   Syarat:
   - Terdapat informasi detail dari seorang user. Berikut beberapa informasi yang wajib ditampilkan pada halaman aplikasi. 
       - TFoto Avatar
       - Username
       - Nama
       - Jumlah Followers
       - Jumlah Following
   - **Catatan:** Pastikan kembali semua informasi tersebut ada.
   - Menampilkan fragment List Follower & List Following yang diambil dari API.
   - Menggunakan Tab Layout dan ViewPager sebagai navigasi antara halaman List Follower dan List Following.

3. Terdapat *indikator loading* saat aplikasi memuat data di semua bagian yang mengambil data dari API, yaitu
   - List data user
   - Detail user
   - List following
   - List follower 

## PENILAIAN
Submission Anda akan dinilai oleh reviewer dengan skala 1-5 berdasarkan dari parameter yang ada.<br>

| Penilaian | Deskripsi |
| --- | --- |
| ![rating-default-1](https://github.com/robbyyehezkiel/Dicoding-Android-Fundamental/assets/107051384/8a625713-034a-4758-8b41-c81539e6fcae) | Semua ketentuan terpenuhi, namun terdapat indikasi plagiat yaitu dengan menggunakan project orang lain dan hanya merubah kontennya saja. |
| ![rating-default-2](https://github.com/robbyyehezkiel/Dicoding-Android-Fundamental/assets/107051384/0e11ca8f-d1f8-4454-b5d7-4efdc6357ef7) | Semua ketentuan terpenuhi, namun terdapat kekurangan pada tampilan aplikasi. |
| ![rating-default-3](https://github.com/robbyyehezkiel/Dicoding-Android-Fundamental/assets/107051384/fb706ca0-34f1-4a99-9483-197b2778544c) | Semua ketentuan wajib terpenuhi, namun tidak terdapat improvisasi atau persyaratan opsional yang dipenuhi. |
| ![rating-default-4](https://github.com/robbyyehezkiel/Dicoding-Android-Fundamental/assets/107051384/30018266-ba2e-449b-8435-d8e6bded3787) | Semua ketentuan terpenuhi dan menerapkan tiga saran di atas. |
| ![rating-default-5](https://github.com/robbyyehezkiel/Dicoding-Android-Fundamental/assets/107051384/72a79b6f-59b6-489f-a183-6d3fe4605e7d) | Semua ketentuan terpenuhi dan menerapkan semua saran di atas. |

Anda dapat menerapkan beberapa saran di bawah ini untuk mendapatkan nilai tinggi, berikut sarannya:

1. Menerapkan tampilan aplikasi yang sesuai standar:
   - Tampilan aplikasi memiliki width, height, margin, dan padding yang sesuai.
   - Pemilihan warna yang sesuai tema aplikasi.
   - Tidak ada komponen yang saling bertumpuk.
   - Penggunaan komponen yang sesuai dengan fungsinya.<br>
     Contoh : Komponen ImageView yang dijadikan sebagai button navigasi.
   - Menggunakan SearchView pada fitur pencarian.
   - Aplikasi bisa memberikan pesan eror jika data tidak berhasil ditampilkan.
    
2. Menuliskan kode dengan bersih.
   - Bersihkan comment dan kode yang tidak digunakan.
   - Indentasi yang sesuai.
   - Menghapus import yang tidak digunakan.
3. Aplikasi bisa menjaga data yang sudah dimuat ketika terjadi pergantian orientasi dari potrait ke landscape atau sebaliknya.
4. Menyimpan informasi yang penting (API Key, Base URL) di dalam BuildConfig pada berkas build.gradle.
5. Menerapkan Android Architecture Component (minimal ViewModel dan LiveData) dengan benar.
   - Tidak membuat satu ViewModel untuk beberapa view sekaligus, tetapi dipisah.
> **Catatan:**
> Jika submission Anda ditolak maka tidak ada penilaian. Kriteria penilaian bintang di atas hanya berlaku jika submission Anda lulus.
