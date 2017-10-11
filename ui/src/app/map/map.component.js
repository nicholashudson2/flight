import templateUrl from './map.component.html'

/* @ngInject */
class MapController {
  zoom = 7
  center = [35.5175, -86.5804]
  markers = []
  paths = []


  constructor($map, locations) {
    this.$map = $map

    // add markers from an angular constant
    // const { chattanooga, knoxville, memphis, nashville } = locations
    // const markers = [knoxville, memphis, nashville]

    // markers.forEach(marker => this.addMarker(marker))

    // add paths manually
    // const paths = [
    //   [memphis, nashville, this.getColor('memphis', 'nashville')],
    //   [nashville, knoxville, this.getColor('nashville', 'knoxville')]
    // ]



    // console.log('memphis-nashville color is' + this.getColor('memphis', 'nashville'))

    // paths.forEach(args => this.addPath(...args))

    // add path from webservice
    // $map.getMarkerByCityName('Chattanooga')
    //   .then(chattanooga => {
    //     this.addMarker(chattanooga)
    //     this.addPath(knoxville, chattanooga, this.getColor('knoxville', 'chattanooga'))
    //   })

    this.displayItineraryMap()

  }

  displayItineraryMap() {
    this.$map.flights.forEach((flight) => {
      console.dir(flight.origin)
      console.dir(flight.destination)
      this.$map.getMarkerByCityName(flight.origin)
        .then(origin => {
          this.$map.getMarkerByCityName(flight.destination)
            .then(destination => {
              this.addMarker(origin)
              console.dir(origin)
              this.addMarker(destination)
              console.dir(destination)
              console.dir(this.getColor(flight.origin, flight.destination))
              this.addPath(origin, destination, this.getColor(flight.origin, flight.destination))
            })
        });
    })
  }

  addMarker({ latitude, longitude }) {
    this.markers.push({
      position: `[${latitude}, ${longitude}]`
    })
  }

  addPath(a, b, color) {
    this.paths.push({
      path: `[[${a.latitude}, ${a.longitude}], [${b.latitude}, ${b.longitude}]]`,
      strokeColor: color,
      strokeOpacity: 1.0,
      strokeWeight: 3,
      geodesic: true
    })
  }

  getColor(a, b) {

    var color = ''

    switch (a) {
      case 'chattanooga':
        switch (b) {
          case 'knoxville':
            this.color = '#E6194B';
            break;
          case 'memphis':
            this.color = '#3CB44B';
            break;
          case 'nashville':
            this.color = '#FFE119';
            break;
          default:
            this.color = '#00FF00';
            break;
        }
        break;
      case 'knoxville':
        switch (b) {
          case 'chattanooga':
            this.color = '#0082C8';
            break;
          case 'memphis':
            this.color = '#F58231';
            break;
          case 'nashville':
            this.color = '#911EB4';
            break;
          default:
            this.color = '#00FF00';
            break;
        }
        break;
      case 'memphis':
        switch (b) {
          case 'chattanooga':
            this.color = '#46F0F0';
            break;
          case 'knoxville':
            this.color = '#F032E6';
            break;
          case 'nashville':
            this.color = '#D2F53C';
            break;
          default:
            this.color = '#00FF00';
            break;
        }
        break;
      case 'nashville':
        switch (b) {
          case 'chattanooga':
            this.color = '#FABEBE';
            break;
          case 'knoxville':
            this.color = '#008080';
            break;
          case 'memphis':
            this.color = '#E6BEFF';
            break;
          default:
            this.color = '#00FF00';
            break;
        }
        break;
    }
    return this.color.toString();
  }

}

export default {
  templateUrl,
  controller: MapController,
  controllerAs: '$mapCtrl'
}
