import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    init() {
        AppKt.InitApp()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
