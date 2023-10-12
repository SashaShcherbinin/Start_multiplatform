package feature.user.presentation.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import base.compose.theme.PreviewAppTheme
import feature.user.domain.entity.User
import feature.user.presentation.Screen
import feature.user.presentation.UserState

@Preview
@Composable
private fun ScreenPreview() = PreviewAppTheme {
    Screen(
        state = UserState(
            user = User(
                id = "1",
                name = "John",
                surname = "Doe",
                email = "",
                photoUrl = "https://example.com/photo.jpg",
            ),
        ),
    )
}