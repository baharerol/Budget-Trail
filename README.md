# Budget Trail - Seyahat Planlayıcı Uygulaması

Bu proje, kullanıcıların belirlediği bütçeye göre önerilen rota ve aktiviteleri görebileceği, tercihlerine göre filtreleme ve kişiselleştirme yapabileceği, veritabanı destekli, şık arayüzlü bir seyahat planlayıcıdır.

## 🚀 Özellikler

- Kullanıcı kayıt ve giriş sistemi
- Bütçeye göre şehir ve aktivite önerileri
- Tercihlere göre filtreleme
- Kişiselleştirilmiş seyahat planları
- Aktivite ve şehir yönetimi
- REST API desteği
- Swagger UI ile API dokümantasyonu

## 🛠️ Teknolojiler

- Spring Boot 2.7.0
- Spring Security
- Spring Data JPA
- MySQL
- Thymeleaf
- Swagger UI
- Maven

## 📋 Gereksinimler

- Java 11
- MySQL 8.0
- Maven 3.6+

## 🔧 Kurulum

1. Projeyi klonlayın:
```bash
git clone https://github.com/yourusername/budget-trail.git
```

2. MySQL veritabanını oluşturun:
```sql
CREATE DATABASE budget_trail;
```

3. `application.properties` dosyasındaki veritabanı bağlantı bilgilerini güncelleyin.

4. Projeyi derleyin ve çalıştırın:
```bash
mvn clean install
mvn spring-boot:run
```

5. Tarayıcınızda şu adresi açın:
```
http://localhost:8080
```

## 📚 API Dokümantasyonu

Swagger UI üzerinden API dokümantasyonuna erişebilirsiniz:
```
http://localhost:8080/swagger-ui/
```

## 🗃️ Veritabanı Şeması

- USERS: Kullanıcı bilgileri
- CITIES: Şehir bilgileri
- ACTIVITIES: Aktivite bilgileri
- TRAVEL_PLANS: Seyahat planları
- PLAN_DETAILS: Plan detayları

## 👥 Katkıda Bulunma

1. Bu depoyu fork edin
2. Yeni bir özellik dalı oluşturun (`git checkout -b feature/amazing-feature`)
3. Değişikliklerinizi commit edin (`git commit -m 'Add some amazing feature'`)
4. Dalınıza push edin (`git push origin feature/amazing-feature`)
5. Bir Pull Request oluşturun

## 📝 Lisans

Bu proje MIT lisansı altında lisanslanmıştır. Daha fazla bilgi için `LICENSE` dosyasına bakın. 