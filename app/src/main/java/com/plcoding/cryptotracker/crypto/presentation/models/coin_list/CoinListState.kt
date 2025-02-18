package com.plcoding.cryptotracker.crypto.presentation.models.coin_list

import androidx.compose.runtime.Immutable
import com.plcoding.cryptotracker.crypto.presentation.models.CoinUi

/**
 * `@Immutable` trong Kotlin (đặc biệt khi dùng với Jetpack Compose) là một annotation giúp chỉ định rằng một class là **bất biến (immutable)**.
 *
 * ### **Bất biến nghĩa là gì?**
 * Một object được gọi là **bất biến** khi **nó không thể bị thay đổi sau khi được khởi tạo**. Điều này có nghĩa là tất cả thuộc tính của class phải là **val** (hằng số) hoặc nếu là danh sách, nó phải là một danh sách bất biến.
 *
 * ### **Trong trường hợp của bạn:**
 * ```kotlin
 * @Immutable
 * data class CoinListState(
 *     val isLoading: Boolean = false,
 *     val coins: List<CoinUi> = emptyList(),
 *     val selectedCoin: CoinUi? = null,
 * )
 * ```
 * - `isLoading`, `coins`, và `selectedCoin` đều là `val`, nghĩa là chúng không thể thay đổi sau khi object được tạo.
 * - `coins: List<CoinUi> = emptyList()` → Mặc định, danh sách này là một `List`, nhưng nếu `CoinUi` không phải là immutable thì danh sách vẫn có thể thay đổi nội dung bên trong.
 * - Nếu muốn danh sách thật sự bất biến, bạn nên sử dụng `List` từ thư viện **Kotlinx Immutable Collections** (`persistentListOf()` thay vì `emptyList()`).
 *
 * ### **Tại sao cần annotation `@Immutable`?**
 * - **Tối ưu hóa hiệu suất trong Compose**:
 *   Jetpack Compose có thể bỏ qua việc recompose khi một state không thay đổi, giúp tối ưu hiệu suất.
 * - **Hạn chế lỗi khi làm việc với state**:
 *   Nếu một class là immutable, bạn không thể vô tình thay đổi nội dung của nó, điều này giúp code an toàn và dễ quản lý hơn.
 *
 * ### **Lưu ý**
 * Annotation `@Immutable` **không thực sự làm class bất biến**, nó chỉ giúp trình biên dịch và Compose hiểu rằng class này nên được xem là immutable. Để đảm bảo bất biến thực sự, bạn nên:
 * ✔ Sử dụng **Immutable Data Structures** như `persistentListOf()` từ **Kotlinx Immutable Collections**.
 * ✔ Đảm bảo rằng tất cả các thuộc tính của class cũng là immutable (ví dụ `CoinUi` cũng nên là `@Immutable`).
 */

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUi> = emptyList(),
    val selectedCoin: CoinUi? = null,
)