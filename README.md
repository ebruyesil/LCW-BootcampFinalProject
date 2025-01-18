# Patika LCW Final Automation Test Project
Bu proje, **LC Waikiki** e-ticaret platformu için otomasyon testleri gerçekleştiren bir test otomasyonu framework'üdür. **Selenium WebDriver**, **TestNG** ve **Allure** entegrasyonları kullanılarak geliştirilmiştir. Projenin amacı, web uygulamasının fonksiyonel testlerini otomatikleştirerek test sürecini hızlandırmak ve güvenilirliğini artırmaktır.

## Kullanılan Teknolojiler ve Araçlar

- **Java**: Proje, Java programlama diliyle yazılmıştır.
- **Selenium WebDriver**: Web uygulamalarını test etmek için kullanılan güçlü bir araçtır. Sayfa etkileşimlerini otomatikleştirir.
- **TestNG**: Test senaryolarını organize etmek ve yönetmek için kullanılan popüler bir test framework'üdür. Testlerin paralel olarak çalıştırılmasına olanak tanır.
- **Allure**: Test sonuçlarını görsel olarak raporlamak için kullanılan bir araçtır. Testlerin durumunu ve geçme/başarısızlık oranlarını detaylı şekilde gösterir.

## Proje Yapısı

- `src/main/java/pages/`: Page Object Model (POM) tasarım desenine göre oluşturulmuş sayfa sınıflarını içerir.
- `src/test/java/tests/`: Testlerin yer aldığı ve TestNG ile organize edilen sınıflar.
- `testng.xml`: TestNG konfigürasyon dosyası.
- `pom.xml`: Maven projesi için bağımlılıkları ve yapılandırmaları içerir.


## Kullanım

Repository'yi lokal bilgisayarınıza klonlayın:

```bash
git clone https://github.com/ebruyesil/LCW-BootcampFinalProject.git
