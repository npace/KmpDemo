import SwiftUI
import shared
import KMMViewModelSwiftUI

struct ContentView: View {
    @StateViewModel var viewModel = MainViewModel()
    
    var body: some View {
        ZStack(content: {
            List(viewModel.state.items,
                 id: \.cheeseName) {
                let item: CheeseViewState = $0
                HStack(content: {
                    Text(item.cheeseName)
                })
            }
            if(viewModel.state.loading) {
                ProgressView()
            }
        })
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
